// 각각의 스크립트는 각각의 project객체와 연관되있고, 스크립트가 실행될때 project객체를 정의
// product객체는 top-level reference

// println(name)
// println(project.name)

// 내가 생성하는 프로퍼티와 메소드는 Script에 선언됨

val dest = "dest"

tasks.register<Copy>("copy") {
    from("source")
    into(dest)
}