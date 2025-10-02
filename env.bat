rem XXX_HOME은 프로그램 끼리 경로를 참조하기 위해서 설정하는 PATH
rem PATH 는 설치 된 프로그램을 경로에 상관없이 사용하기 위해서 설정하는 PATH
rem CLASSPATH : 외부jar안에(class가 단독으로 존재) class를 경로에 상관없이 참조하고 사용하기 위해

set DEV_HOME=c:\dev

set JAVA_HOME=%DEV_HOME%\java-17-openjdk-17.0.3.0.6-1
set ECLIPSE_HOME=%DEV_HOME%\eclipse

set CLASSPATH=.;%DEV_HOME%\drivers\ojdbc8.jar
set PATH=%PATH%;%JAVA_HOME%\bin;%ECLIPSE_HOME%