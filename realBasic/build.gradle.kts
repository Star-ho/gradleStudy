// gradle이 실행되면서 tasks.register로 등록된 테스크를 등록
// gralde ${task명} 으로 task실행가능
// repeat를 사용하여 반복가능
// taske.named로 명령 추가 가능
// defaultTasks로 기본 task설정가능

defaultTasks("hello", "upper")

tasks.register("hello") { //기본 출력
    doFirst {
        println("Hello world!")
    }
}

tasks.register("upper") {
    doLast {
        val someString = "SungHo"
        println("Original: $someString") //문자 리터럴
        println("Upper case: ${someString.toUpperCase()}") //
    }
}

tasks.register("count"){ //repeat 예제
    doLast {
    repeat(4) {print("$it ")} //반복
    }
}

tasks.register("intro"){
    dependsOn("hello") // 의존
    doLast{
        println("I'm Sungho")
    }
}

tasks.register("taskA"){ 
    dependsOn("taskB") // lazy loading
    doLast{
        println("test A!")
    }
}

tasks.register("taskB"){ 
    doLast{
        println("test B!")
    }
}


repeat(4) { counter -> 
    tasks.register("couterTask$counter"){
        doLast{
            println("I'm tesk number $counter")
        }
    }
}



tasks.named("hello"){ 
    doLast{
        println("im gradle!")
    }
}

tasks.named("hello"){ 
    doFirst{
        println("Hi, im sungho,and you?")
    }
}

tasks.named("hello"){ 
    doLast{
        println("nice to meet you")
    }
}

tasks.register("loadfile") {
    doLast {
        val files = file("./antLoadfileResources").listFiles().sorted()
        files.forEach { file ->
            if (file.isFile) {
                ant.withGroovyBuilder {
                    "loadfile"("srcFile" to file, "property" to file.name)
                }
                println(" *** ${file.name} ***")
                println("${ant.properties[file.name]}")
            }
        }
    }
}