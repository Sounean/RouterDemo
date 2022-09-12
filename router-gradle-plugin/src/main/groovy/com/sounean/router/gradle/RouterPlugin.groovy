package com.sounean.router.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

// 整个插件的入口
class RouterPlugin implements Plugin<Project> {

    // 实现apply方法，注入插件的逻辑
    void apply(Project project){    // 当其他引用了插件的使用apply时就会调用这里的方法
            println("I am from RouterPlugin, apply from ${project.name}")

            project.getExtensions().create("router", RouterExtension)   // 前面一个可以自定义一个名字，后面写要注册的类名

            project.afterEvaluate{  // 当afterEvaluate时表示配置阶段结束了，说明该gradle有被引用。到了这步就能拿到router
                RouterExtension extension = project["router"]

                println("用户设置的WIKI路径为 : ${extension.wikiDir}")
            }
    }
}