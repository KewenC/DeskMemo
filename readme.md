
## 《桌面备忘录》开发说明书

- 应用名称:桌面备忘录 Desk Memo
- 普通模块:文本、录音、图片、视频、天气
- 生日模块:农历、阴历、日历
- 购物模块:清单、计算
- 书籍模块:清单、书签
- 设置模块:主题、分享、关于、评分
- 附加:快捷粘贴







## 系统命名规范

### 1 布局文件命名 前缀_辑名”
- Activity : activity_xx
- Fragment : fragment_xx
- 自定义控件 : view_xx
- 对话框 : dialog_xx
- 列表项：item_xx

### 2 资源文件命名 前缀_块名_辑名称
- 按钮：btn_xx    btn_xx_normal  btn_xx_pressed
- 图标：ic_xx
- 背景图片：bg_xx
- 分隔线：divider_gray

### 3 类的命名
- Activity : XxActivity
- Fragment : XxFragment
- Service : XxService
- BroadcastReceiver ：XxReceiver
- ContentProvider : XxProvider

### 4 工具类 ：XxUtil
- 自定义的公共基础类 ：XxActivity(BaseActivity)
- 单元测试的类 : XxTest(HashTest)

### 5 命名约定
- 类的命名：大驼峰命名法UpperCamelCase
- 方法名和变量名：小驼峰命名法lowerCamelCase
- 常量：大写字母，单词之间以下划线分隔static final int CONNECTION_TIMEOUT= 1000；
