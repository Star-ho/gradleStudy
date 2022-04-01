// buildscript를 사용하여 클래스 패스 생성 
// 평소에 implemetation과 같이 그룹,네임,버전 정의
// 멀티프로젝트에서 buildscript()로 정의하면 하위 프로젝트에서 사용가능

import org.apache.commons.codec.binary.Base64

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        "classpath"(group = "commons-codec", name = "commons-codec", version = "1.2")
    }
}

tasks.register("encode") {
    doLast {
        val encodedString = Base64().encode("hello world\n".toByteArray())
        println(String(encodedString))
    }
}