####File-->Settings

##Editor--
1 General
1.1 Auto Import
勾选Add unambiguous imports on the fly，自动导入没有歧义的类
勾选optimize imports on th fly(for current project)，在写代码的同时自动维护import

1.2 Appearance
勾选show method separator，显示方法分隔符
不勾选show parameter name hints，不需要显示参数名

1.3 code completion
match case，不勾选，代码智能提醒时，不区分大小写

1.4 code folding
全部不勾选，不用收起代码，方便查看代码

1.5  file encoding , 全部选择utf-8


##plugins, 常用插件
lombok plugin
alibaba java coding guidelines
properties to yaml converter
statistic
jrebel

##version control
1 git
path to git executable,选择git.ext命令的路径，举例：D:\Program Files\Git\bin\git.exe

##build,execution,deployment
1 build tools
1.1 maven
1.1.1
maven不需要自己安装，直接用idea自带的，maven home director默认是：bundled (maven 3)

1.1.2 配置从阿里云仓库下载代码
修改idea自带的maven的配置，路径参考：D:\soft\ideaIU-2018.1.5.win\plugins\maven\lib\maven3\conf\settings.xml
在<mirrors>中增加如下配置，从阿里云仓库下载jar文件
	<mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>
    </mirror>

<localRepository>/path/to/local/repo</localRepository>可以修改本地仓库的保持路径
修改为：
<localRepository>D:\mavenrepository</localRepository>

1.1.3 importing
勾选automatically download sources，自动下载源代码

1.2 compiler
根据需要，勾选或不勾选build project automatically, 自动编译


##tools
1 web browsers
把chrome移到第一个，并在default browser选first listed


#设置author
IntelliJ IDEA 2016.1.1\bin”的“idea64.exe.vmoptions文件的尾部加上一行：
-Duser.name=作者名
比如
-Duser.name=yangyueming
重启IDEA


####project structure
项目结构和模块信息
设置jdk相关信息


####File-->Settings
setting for new projects 设置后续所有项目的默认设置
setting structure for new projects 设置后续所有项目的默认设置后续所有项目的默认设置






