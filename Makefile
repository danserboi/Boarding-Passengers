JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Bilet.java \
        Persoana.java \
	Pasager.java \
	Grup.java \
	Familie.java \
	Singur.java \
	CoadaDePrioritate.java \
        Tema1.java 

default:  classes

classes: $(CLASSES:.java=.class)

run: classes
	java Tema1
clean:
	$(RM) *.class
