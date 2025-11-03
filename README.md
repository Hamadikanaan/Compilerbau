Ich habe allein an der Aufgabe gearbeitet. Ich habe mit ANTLR eine Grammatik für eine kleine Sprache erstellt, die einfache Anweisungen wie Zuweisungen, 
if/else und while unterstützt. Danach habe ich einen Pretty Printer programmiert, der das Programm automatisch schön formatiert ausgibt.

Details

Ein wichtiger Teil war die Grammatik. Ich musste genau überlegen, wo Zeilenumbrüche erlaubt sind und wie das Schlüsselwort „do“ funktioniert. 
Besonders interessant war, dass der Parser am Anfang Fehler zeigte, wenn „do“ in einer neuen Zeile stand. Ich habe die Grammatik so angepasst, 
dass beide Varianten funktionieren – „if 10 < 1 do“ und „if 10 < 1\n do“.
Außerdem konnte ich mit ANTLR den Parse Tree sehen und prüfen, ob alles richtig erkannt wurde.

Reflexion – Schwierigkeit

Das Schwierigste war, die Grammatik so zu schreiben, dass sie wirklich alle Fälle akzeptiert und keine „missing NL“-Fehler mehr zeigt. 
Ich habe das Problem gelöst, indem ich viel ausprobiert und den Aufbau der Regeln schrittweise verbessert habe. 
Dabei habe ich auch gelernt, wie ANTLR mit Zeilenumbrüchen und Whitespaces umgeht.

Reflexion – Gelerntes

Ich habe gelernt, wie man mit ANTLR eine eigene Sprache beschreibt und wie der Parse Tree aufgebaut ist. 
Außerdem habe ich besser verstanden, wie ein Pretty Printer funktioniert und warum saubere Formatierung wichtig ist. 
Ich habe auch gelernt, geduldig und systematisch zu testen, bis der Code stabil läuft.

LG

