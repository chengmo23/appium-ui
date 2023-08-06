# 一、PO模式简介
### 1.起源
PO模式是国外大神Martin Fowler于2013年提出来的一种设计模式，其基本思想是强调代码逻辑和业务逻辑相分离。
[https://martinfowler.com/bliki/PageObject.html](https://martinfowler.com/bliki/PageObject.html)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23115155/1661958985346-ab48bb99-a863-4f1a-8bb0-7a78de149efc.png#averageHue=%23b8d9a3&clientId=u01506736-e0b4-4&from=paste&height=478&id=u891e5126&originHeight=955&originWidth=1080&originalType=binary&ratio=1&rotation=0&showTitle=false&size=309477&status=done&style=none&taskId=u9999e5ed-870a-4728-b95d-8cb1e0c9b0b&title=&width=540)
### 2.PO六大原则
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23115155/1661959327768-1393013f-0b89-4ce4-a777-db4e2f786340.png#averageHue=%23f0f0f0&clientId=u01506736-e0b4-4&from=paste&height=197&id=ua2a250f4&originHeight=394&originWidth=1024&originalType=binary&ratio=1&rotation=0&showTitle=false&size=151176&status=done&style=none&taskId=ua1b1402d-c89d-4994-a450-7d9ffc73a7e&title=&width=512)
翻译成中文就是：
> 公共方法表示页面提供的服务
> 尽量不要暴露页面的内部实现
> 页面中不要加断言，断言加载
> 方法返回另外的页面对象
> 不需要封装全部的页面元素
> 相同的行为、不同的结果，需要封装成不同的方法

### 3.PO设计模式分析

- 用Page Object表示UI
- 减少重复样本代码
- 让变更范围控制在Page Object内
- 本质是面向对象编程
### 4.PO封装的主要组成元素

- Driver对象：完成对WEB、Android、iOS、接口的驱动
- Page对象：完成对页面的封装
- 测试用例：调用Page对象实现业务并断言
- 数据封装：配置文件和数据驱动
- Utils：其他功能/工具封装，改善原生框架不足
### 5.业内常见的分层模型
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23115155/1661959783248-e224abd9-a949-4140-b56d-4d5f9b433f18.png#averageHue=%23cddeba&clientId=u01506736-e0b4-4&from=paste&height=363&id=uf015ab76&originHeight=726&originWidth=1024&originalType=binary&ratio=1&rotation=0&showTitle=false&size=336169&status=done&style=none&taskId=u4bedb193-bb56-4a4e-ac22-b08a839ab0c&title=&width=512)
#### 1）四层模型

- Driver层完成对webdriver常用方法的二次封装，如：定位元素方法；
- Elements层：存放元素属性值，如图标、按钮的resourceId、className等；
- Page层：存放页面对象，通常一个UI界面封装一个对象类；
- Case层：调用各个页面对象类，组合业务逻辑、形成测试用例。
#### 2）三层模型（推荐）
四层模型与三层模型唯一的区别就是将Page层与Elements层存放在一起；
各个页面对象文件同时包含当前页面中各个图标、按钮的resourceId、className等属性值，以便随时调用。
# 二、APP自动化测试实战
### 1.设计项目结构
```bash
.
├── conftest.py
├── pom
│   ├── __init__.py
│   ├── basepage.py
│   ├── bbspage
│   │   ├── __init__.py
│   │   ├── searchpage.py
│   └── mainpage
│       ├── __init__.py
│       ├── bbspage.py
│       ├── homepage.py
│       └── minepage.py
├── resource
│   └── app-auto-test
│       ├── zeekr-01-01.png
│       ├── zeekr-01-02.png
│       ├── zeekr-01-03.png
│       ├── zeekr-02-01.png
│       ├── zeekr-02-02.png
│       ├── zeekr-02-03.png
│       ├── zeekr-03-01.png
│       ├── zeekr-03-02.png
│       ├── zeekr-03-03.png
│       ├── zeekr-04-01.png
│       ├── zeekr-04-02.png
│       ├── zeekr-04-03.png
│       ├── zeekr-05-01.png
│       ├── zeekr-05-02.png
│       └── zeekr-05-03.png
└── testcases
├── __init__.py
    └── test_hot_search.py
```
### 2.配置appium连接参数
```python
# _*_coding: utf-8 _*_

"""
Create by Zimo on 2022/3/10.
"""

import time
import pytest
from appium import webdriver  # appium 的 webdriver


@pytest.fixture(scope='session')
def driver():
    desired_caps = {
        "platformName": "Android",
        "appium:platformVersion": "11",
        "appium:automationName": "UiAutomator2",
        "appium:deviceName": "HUAWEI",
        "appium:appPackage": "com.zeekrlife.mobile",
        "appium:appActivity": "com.zeekrlife.main.SplashActivity",
        "appium:noReset": True,
        "appium:autoAcceptAlerts": True
    }
    app = webdriver.Remote('http://127.0.0.1:4723/wd/hub', desired_caps)
    time.sleep(3)
    app.implicitly_wait(10)  # 全局的隐式等待时间
    
    yield app  # 将driver传递出来
    # 所有的用例执行之后
    app.quit()

```
### 3.封装BasePage
即Driver层，对uiautomator2进行二次封装，所有Page类都会直接或间接继承BasePage
```python
# _*_coding: utf-8 _*_

"""
所有页面的基类
Create by Zimo on 2022/3/12.
"""

from appium.webdriver.webdriver import WebDriver
from appium.webdriver.common.appiumby import AppiumBy as By

command_ime_list = 'adb shell ime list -s'
command_set_sogou = 'adb shell ime set com.sohu.inputmethod.sogou/.SogouIME'
command_set_unicode = 'adb shell ime set io.appium.settings/.UnicodeIME'


class BasePage:
    """
    第一层：对WebDriver进行二次封装，定义一个所有页面都继承的BasePage
    封装WebDriver基本方法，如：元素定位，元素等待，翻页等
    不需要全部封装，用到多少就封装多少
    """

    def __init__(self, webdriver: WebDriver):
        self.app = webdriver
        self.size = self.app.get_window_size()

    def find_element_by_id(self, element_id):
        """通过id定位单个元素"""
        try:
            return self.app.find_element(By.ID, element_id)
        except Exception as e:
            print(f'页面中没有找到id为{element_id}的元素')
            raise e

    def find_elements_by_id(self, element_id):
        """通过id定位多个元素"""
        try:
            return self.app.find_elements(By.ID, element_id)
        except Exception as e:
            print(f'页面中没有找到id为{element_id}的元素')
            raise e
        
    def find_element_by_xpath(self, element_xpath):
        """通过xpath定位单个元素"""
        try:
            return self.app.find_element(By.XPATH, element_xpath)
        except Exception as e:
            print(f'页面中没有找到xpath为{element_xpath}的元素')
            raise e

    def find_elements_by_xpath(self, element_xpath):
        """通过xpath定位多个元素"""
        try:
            return self.app.find_elements(By.XPATH, element_xpath)
        except Exception as e:
            print(f'页面中没有找到xpath为{element_xpath}的元素')
            raise e

    def get_toast_text(self) -> str:
        """获取toast文本"""
        toast = self.app.find_element(By.XPATH, '//android.widget.Toast')
        return toast.text

    def swipe_up(self, start_ratio: float, ratio=0.5, x=0.5, t=2000, n=1):
        """向上滑动屏幕"""
        if 0 < start_ratio - ratio < 1:
            start_x = int(self.size['width'] * x)
            start_y = int(self.size['height'] * start_ratio)
            end_y = int(self.size['height'] * (start_ratio - ratio))
            for i in range(n):
                self.app.swipe(start_x, start_y, start_x, end_y, t)

    def swipe_down(self, start_ratio: float, ratio=0.5, x=0.5, t=2000, n=1):
        """向下滑动屏幕"""
        if 0 < ratio + start_ratio < 1:
            start_x = int(self.size['width'] * x)
            start_y = int(self.size['height'] * start_ratio)
            end_y = int(self.size['height'] * (start_ratio, + ratio))
            for i in range(n):
                self.app.swipe(start_x, start_y, start_x, end_y, t)

    def swipe_left(self, start_ratio: float, ratio=0.5, y=0.5, t=2000, n=1):
        """向左滑动屏幕"""
        if 0 < start_ratio - ratio < 1:
            start_x = int(self.size['width'] * start_ratio)
            start_y = int(self.size['height'] * y)
            end_x = int(self.size['width'] * (start_ratio - ratio))
            for i in range(n):
                self.app.swipe(start_x, start_y, end_x, start_y, t)

    def swipe_right(self, start_ratio: float, ratio=0.5, y=0.5, t=2000, n=1):
        """向右滑动屏幕"""
        if 0 < ratio + start_ratio < 1:
            start_x = int(self.size['width'] * start_ratio)
            start_y = int(self.size['height'] * y)
            end_x = int(self.size['width'] * (start_ratio + ratio))
            for i in range(n):
                self.app.swipe(start_x, start_y, end_x, start_y, t)

    def swipe_custom(self, start_x, start_y, end_x, end_y, t=500):
        """自定义滑动屏幕"""
        self.app.swipe(start_x, start_y, end_x, end_y, t)


```
### 4.定义各个页面Page
所有页面Page类都继承BasePage。根据PO模式六大原则之一的“不需要封装全部的页面元素”，用到多少页面元素就封装多少。例如：当前待测APP有3个界面，则定义3个页面Page：

- home_page.py
- bbs_page.py
- mine_page.py
#### 1）home_page.py
```python
# _*_coding: utf-8 _*_

"""
Create by Zimo on 2022/3/12.
"""

from appium.webdriver.webdriver import WebDriver
from pom.basepage import BasePage
from pom.mainpage.bbspage import BbsPage

from pom.mainpage.findpage import FindPage
from pom.mainpage.minepage import MinePage


class HomePage(BasePage):
    """
    主App模型
    """

    def __init__(self, webdriver: WebDriver):
        super().__init__(webdriver)
        self.bbs_icon = 'com.zeekrlife.mobile:id/tab_community'
        self.find_icon = 'com.zeekrlife.mobile:id/tab_message'
        self.vehicle_icon = 'com.zeekrlife.mobile:id/tab_vehicle'
        self.mall_icon = 'com.zeekrlife.mobile:id/tab_mall'
        self.mine_icon = 'com.zeekrlife.mobile:id/tab_mine'

    def click_bbs_icon(self) -> BbsPage:
        """
        跳转"社区"页面
        :return: BbsPage
        """
        self.find_element_by_id(self.bbs_icon).click()
        return BbsPage(self.app)

    def click_find_icon(self):
        """
        跳转"发现"页面
        :return: FindPage
        """
        self.find_element_by_id(self.find_icon).click()
        return FindPage(self.app)

    def click_vehicle_icon(self):
        """
        跳转"爱车"页面
        :return:
        """
        self.find_element_by_id(self.vehicle_icon).click()
        # TODO

    def click_mall_icon(self):
        """
        跳转"极物"页面
        :return:
        """
        self.find_element_by_id(self.mall_icon).click()
        # TODO

    def click_mine_icon(self):
        """
        跳转"我的"页面
        :return: MinePage
        """
        self.find_element_by_id(self.mine_icon).click()
        return MinePage(self.app)

```
#### 2）bbs_page.py
```python
# _*_coding: utf-8 _*_

"""
Create by Zimo on 2022/3/12.
"""

from appium.webdriver.webdriver import WebDriver

from pom.basepage import BasePage
from pom.bbspage.writeshortpostpage import WriteShortPostPage


class BbsPage(BasePage):
    """
    "社区"页面模型
    """

    def __init__(self, webdriver: WebDriver):
        super().__init__(webdriver)
        self.add_icon = 'com.zeekrlife.mobile:id/imgv_add'
        self.short_icon = 'com.zeekrlife.mobile:id/tv_short'
        self.long_icon = 'com.zeekrlife.mobile:id/tv_long'
        self.question_icon = 'com.zeekrlife.mobile:id/tv_question'
        self.friend_icon = 'com.zeekrlife.mobile:id/new_friend'
        self.scan_icon = 'com.zeekrlife.mobile:id/tv_scan'
        self.search_box = 'com.zeekrlife.mobile:id/search_view_flipper'
        self.recommend_tab = '//android.widget.LinearLayout[@content-desc="推荐"]'
        self.news_tab = '//android.widget.LinearLayout[@content-desc="资讯"]'
        self.faq_tab = '//android.widget.LinearLayout[@content-desc="问答"]'
        self.dynamic_tab = '//android.widget.LinearLayout[@content-desc="动态"]'

    def click_add(self):
        """
        点击"+"号
        :return: None
        """
        self.find_element_by_id(self.add_icon).click()
        # time.sleep(1)

    def click_short_icon(self):
        """
        发动态
        :return: WriteShortPostPage
        """
        self.find_element_by_id(self.short_icon).click()
        return WriteShortPostPage(self.app)

    def click_long_icon(self):
        """
        发文章
        :return:
        """
        self.find_element_by_id(self.long_icon).click()
        # TODO

    def click_question_icon(self):
        """
        去提问
        :return:
        """
        self.click_add()
        self.find_element_by_id(self.question_icon).click()
        # TODO

    def click_friend_icon(self):
        """
        加好友
        :return:
        """
        self.click_add()
        self.find_element_by_id(self.friend_icon).click()
        # TODO

    def click_scan_icon(self):
        """
        扫一扫
        :return:
        """
        self.click_add()
        self.find_element_by_id(self.scan_icon).click()
        # TODO

    def click_search_box(self):
        """
        跳转"搜索"页面
        :return:
        """
        self.find_element_by_id(self.search_box).click()
        # TODO

    def click_recommend_tab(self):
        """
        跳转"推荐"页面
        :return:
        """
        self.find_element_by_xpath(self.recommend_tab).click()
        # TODO

    def click_news_tab(self):
        """
        跳转"资讯"页面
        :return:
        """
        self.find_element_by_xpath(self.news_tab).click()
        # TODO

    def click_faq_tab(self):
        """
        跳转"问答"页面
        :return:
        """
        self.find_element_by_xpath(self.faq_tab).click()
        # TODO

    def click_dynamic_tab(self):
        """
        跳转"动态"页面
        :return:
        """
        self.find_element_by_xpath(self.dynamic_tab).click()
        # TODO

```
#### 3）search_page.py
```python
# _*_coding: utf-8 _*_

"""
Create by Zimo on 2022/3/13.
"""

from appium.webdriver.webdriver import WebDriver

from pom.basepage import BasePage


class SearchPage(BasePage):
    """
    搜索-页面模型
    """

    def __init__(self, webdriver: WebDriver):
        super().__init__(webdriver)
        self.search_box = 'com.zeekrlife.mobile:id/editSearch'
        self.synthesize_tab = '//android.widget.LinearLayout[@content-desc="内容"]'
        self.faq_tab = '//android.widget.LinearLayout[@content-desc="问答"]'
        self.square_tab = '//android.widget.LinearLayout[@content-desc="广场"]'
        self.activity_tab = '//android.widget.LinearLayout[@content-desc="活动"]'
        self.user_tab = '//android.widget.LinearLayout[@content-desc="用户"]'
        self.clear_search_icon = 'com.zeekrlife.mobile:id/imgv_clear'
        self.delete_history_icon = 'com.zeekrlife.mobile:id/imgv_delete'
        self.search_history = '//*[@resource-id="com.zeekrlife.mobile:id/flexbox"]/android.widget.TextView'
        self.back_icon = 'com.zeekrlife.mobile:id/toolbar_left_imgv'

    def input_search_box(self, content):
        """
        搜索
        :param content:搜索内容
        :return:None
        """
        self.find_element_by_id(self.search_box).click()
        self.find_element_by_id(self.search_box).send_keys(content)
        self.app.keyevent(66)

    def click_synthesize_tab(self):
        """
        点击综合
        :return:None
        """
        self.find_element_by_xpath(self.synthesize_tab).click()

    def click_faq_tab(self):
        """
        点击问答
        :return:None
        """
        self.find_element_by_xpath().click()

    def click_square_tab(self):
        """
        点击广场
        :return:None
        """
        self.find_element_by_xpath(self.square_tab).click()

    def click_activity_tab(self):
        """
        点击活动
        :return:None
        """
        self.find_element_by_xpath(self.activity_tab).click()

    def click_user_tab(self):
        """
        点击用户
        :return:None
        """
        self.find_element_by_xpath(self.user_tab).click()

    def clear_search_box(self):
        """
        清除搜索内容
        :return:None
        """
        self.find_element_by_id(self.clear_search_icon).click()

    def clear_search_history(self):
        """
        删除历史搜索记录
        :return:None
        """
        self.find_element_by_id(self.delete_history_icon).click()

    def get_search_history(self):
        """
        获取搜索历史
        :return:None
        """
        search_history_list = []
        ele_list = self.find_elements_by_xpath(self.search_history)
        for search_history in ele_list:
            search_history_list.append(search_history.text)
        return search_history_list

    def click_back_icon(self):
        """
        返回社区页面
        :return:None
        """
        self.find_element_by_id(self.back_icon).click()

```
### 5.编写测试用例
测试用例实际上是调用各个页面对象组合成的一个业务逻辑集合，中间再加入一些控制结构（选择结构if...else、循环结构for）、断言等，就形成了最终的测试用例。
```python
# _*_coding: utf-8 _*_

"""
环境测试
Create by Zimo on 2022/3/10.
"""

from pom.mainpage.homepage import HomePage


def test_search(driver):
    home = HomePage(driver)
    bbs = home.click_bbs_icon()
    search = bbs.click_search_box()
    search.search("续航")
    search.clear_search_box()
    search_history = search.get_search_history()
    assert "续航" == search_history[0]
```
### 6.运行效果
![test.gif](https://cdn.nlark.com/yuque/0/2022/gif/23115155/1662016162615-8a806e82-6030-42f5-ade7-cdedae39c70b.gif)
