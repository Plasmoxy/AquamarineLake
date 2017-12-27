echo "COMPILING JAVA"
javac -cp . *.java
echo "COMPILING KOTLIN"
kotlinc -cp . *.kt
echo "--- RUNNING hw ---"
java -cp "$env:KOTLINLIB\kotlin-runtime.jar;." hw
