# uzh-wi2-camunda

Dieses Projekt stellt eine einfache Umgebung zur verfügung um die Welt von Camunda zu erkunden.
Beispielhaft ist ein Prozess hinterlegt, welcher eine Zeiterfassung simuliert.
Gespeichert werden die Einträge automatisch in einer SQL-Datenbank.

Das Projekt ist ein Maven-Projekt und sollte ohne irgendwelche Änderungen sofort funktionieren.
Nach dem auschecken einfach mit Netbeans öffnen (!!! NICHT IMPORTIEREN, sondern ÖFFNEN !!!) einfach "Clean & Build" ausführen und das Projekt danach mit Run staten.

Danach sollte Camunda per Browser über http://localhost:8080 zur Verfügung stehen.

Noch ein Wort zu den Datenbanken:
Im Hintergrund kommt eine H2-Datenbank zum Einsatz. Diese ist besonders leichgewichtig, muss nicht installiert werden und speicher alle Einträge in einer lokalen Datei. In unserem Fall ist dies "uzh-wi2.mv.db"
Auf die Datenbank könnt ihr bei laufendem Projekt unter http://localhost:8080/console zugreifen.
Dort müsst ihr darauf achten, dass ihr den richtigen Pfad angebt. Bei mir ist dies: jdbc:h2:~/Development/WI2/uzh-wi2-camunda-master/uzh-wi2 wobei sich die ~ (Windows/Mac und Linux) auf das Home-Directory bezieht.

Die Abbildung von Java-Objekten in die Datenbank-Tabellen geschieht mit Hilfe von "Hibernate". Mit dieser Schicht solltet ihr allerdings nichts zu tun haben, da sie sich komplett hinter JPA (Java Persistence API) verbirgt. Ich schreibe auch das alles, damit ihr einen guten Ausgangspunkt habt, wenn Ihr in google nach Tutorials und Informationen sucht.
