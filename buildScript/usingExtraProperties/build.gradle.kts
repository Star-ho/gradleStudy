// extra는 사용자가 정의할수 있는 프로퍼티
// 프로젝트나 task, source set에 제한되지않음
// ++ sourse set? https://docs.gradle.org/current/dsl/org.gradle.api.tasks.SourceSet.html 참고


plugins{
    id("java-library")
}

val springVersion by extra("3.1.0 RELEASE")
val emailNotification by extra("starho1994@gmail.com")

sourceSets.all{ extra["purpose"] = null } // 필수는 아닌데 왜 넣있을지 의문

sourceSets {
    main {
        extra["purpose"] = "production"
    }
    test {
        extra["purpose"] = "test"
    }
    create("plugin"){
        extra["purpose"] = "production"
    }
}

tasks.register("printProperties"){
    doLast{
        println(springVersion)
        println(emailNotification)
        sourceSets.matching { it.extra["purpose"] == "production" }.forEach{ println(it.name) }
    }
}