# Camunda
Authors: Nik Zaugg, Alex Scheitlin

This process provides a basic environment for Camunda. In the project template a example process is already implemented.
All data is stored in a SQL-Database

## Project
This is a maven project.

Oracle Virtual Box: 5.2.0

### How to run
1. clone repo
2. Open IntelliJ
3. Open...
4. Select /myrepositories/camunda
5. Wait until dependencies are loaded
6. Click on 'Run' ->  'Run TimeRegistryStarter'
7. TomCat server starts up
8. Go to localhost:8080 to access Camunda
9. login with demo:demo

### Start a process in Camunda
1. Click on Tasklist
2. On top right click on 'Start Process'
3. Fill out form and hit 'start'
4. Process has finished - in the IntelliJ console there should be a printout: 'Stored!'

### Open H2 Database
1. Navigate to localhost:8080/console
2. At JDBC enter `paht\to\repository\camunda\uzh-wi2` (IMPORTANT: use `jdbc:h2:~/` at the beginning and only type `uzh-wi2` and NOT `uzh-wi2.db` -> e.g. `jdbc:h2:~/camunda/uzh-wi2` points to `C:/Users/Alex/camunda/uzh-wi2`)
3. Enter 'sa' for both user name and password
4. Connect to DB
5. Check if data was stored in table 'TIME_RECORD'

## Odoo

### Setup Virtual Box
1. Download odoo image from imrg-cloud
2. Install Virtual Box (https://www.virtualbox.org/wiki/Downloads)
3. Open Virtual Box -> File --> Open Appliance --> select Odoo image
4. Allocate enough RAM, maybe even 2 CPU cores

### Enable connection between host and VM
We need to add a second Network Adapter to the VM in order to access the Odoo-VM which will serve as our Odoo-Server.
After this setup you will be able to access the VM via your own browser.

1. Click on 'Global Tools' on the top-right
2. Click 'Host-only Networks'
3. Click 'Create' (a new adapter will be created)
4. Select the new adapter and click 'Properties'
5. Configure Addresses (tab 'Adapter')

| Adapter      |   IP      | 
| -------------|-----------| 
| IPv4 Address | 192.168.56.1 |
| IPv4 Network Address  | 255.255.255.0  |  

6.  Enable DHCP Server (tab 'DGCP-Server')

| DHCP        |   IP      | 
| ------------- |:-------------:| 
| Server Address      | 192.168.56.1 |
| Server Mask      | 255.255.255.0      | 
| Lower Address Bound      | 192.168.56.101 | 
| Upper Address Bound      | 192.168.56.254 |

7. Click 'Save'
8. Click on 'VM-Tools' on the top-right
9. Right-click on your machine -> 'Preferences' -> 'Network' -> 'Adapter2'
10. Select previously added Adapter and press 'OK'
11. Start up your virtual Image
12. Enter 'wi2017' for both user name and password

#### Inside the Virtual Machine
1. Open Terminal
2. Run `sudo apt-get install net-tools`
3. Type `ifconfig` to see if you now have `enp0s8` with IP `192.168.56.101`
4. If yes -> type `sudo vi /etc/network/interfaces`and add the following two lines
    `auto enp0s8`
    `iface enp0s8 inet dhcp`
5. save and close
6. Try the connection: `ping -c5 192.168.56.101` --> sends 5 packets

#### On Host
1. Open Browser
2. Open http://192.168.56.101:8069
3. You should see the Odoo login screen
4. Create new data base with your own credentials for a clean environment (or follow step 5) 
5. Enter 'demo' for both user name and password

## Initial Description by Peter Heinrich
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
