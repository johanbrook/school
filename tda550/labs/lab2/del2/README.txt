	
	README
	====================
	
	TDA550, Lab 2 - del 2. Geometriska former
	Grupp 15
	
	- Robin Andersson
	- Johan Brook
	
	Noteringar
	--------------------
	
	1.
		I vår compareTo-metod i Shape har vi inte tagit hänsyn till om objekten är lika eller ej – 
		endast om de har samma storlek sett till area och sedan omkrets.
		
		Det leder till att man i testprogrammet inte kan lägga till en rektangel och en kvadrat med
		samma mått. Man kan heller inte lägga till två rektanglar med samma area och omkrets 
		(t.ex. en rektangel på 20x30 och en till på 30x20 – enligt compareTo är de lika).
		
		Vi tog beslutet i samråd med handledare och labbeskrivningen.
		
		Se även:
		http://blog.tremend.ro/2007/05/17/problem-when-adding-elements-to-a-treesetcomparator-some-elements-are-not-added/
		http://docs.oracle.com/javase/6/docs/api/java/lang/Comparable.html
	
	2.	
		I Shape har vi inte överskuggat equals() från Object, utan använder en protected equals()-
		metod som tar en GeometricalForm, och som endast jämför nullreferens, klass, och färg. 
		Vi anropar denna genom super.equals(GeometricalForm o) i subklasserna där vi vill jämföra
		färg.
	
	3. 
		Vi har valt att inte ha separata equals() och hashCode()-metoder i Square, då Square
		ärver Rectangle, och därmed använder Rectangles metoder för detta. Rectangles equals()
		och hashCode()-metoder fungerar på exakt samma sätt som metoderna hade gjort i Square.
		
	4.
		I Line.java har vi en hjälpmetod, calculateDeltaAndSlope(), som räknar ut linjens lutning,
		samt dx och dy för andra punkten i linjen, samt lägger dessa i instansvariabler. Vi utför
		denna syssla i de båda konstruktorerna, och det hade annars blivit mycket duplicerad kod.
		
	5. 
		Vi har en till hjälpmetod i Shape, som kollar om värden är negativa och kastar ett
		IllegalPositionException. Vi utför denna syssla i princip alla subklasser, så vi 
		tyckte att en gemensam hjälpmetod för detta var passande. Den är överlagrad med
		en metod som även tar en sträng som meddelande för IllegalPositionException.
		
	6.
		Vi har även en egen testklass, GeometricalFormTest, för test av equals, compareTo,
		och annat.
		