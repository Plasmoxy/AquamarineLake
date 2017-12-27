echo "COMPILING JAVA"
javac -cp . *.java

echo "COMPILING KOTLIN"
kotlinc -cp . *.kt

echo "--- RUNNING hw ---"
kotlin hw
