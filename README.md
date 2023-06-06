# CarOps Information System

<img src="img/UOMLOGOGR.png#gh-light-mode-only" alt= “University of Macedonia logo for light mode” width="20%" height="20%"> 
<img src="img/UOMLOGOGRWHITE.png#gh-dark-mode-only" alt= “University of Macedonia logo for dark mode” width="20%" height="20%"> 

<table>
  <caption>Ομάδα 28</caption>
    <tr>
        <th>Τζήκα</th>
        <th>Τσολακίδης</th>
        <th>Φουλίδης</th>
        <th>Χαϊντάρι</th>
        <th>Χαμαλίδης</th>
    </tr>
    <tr>
        <td>Δήμητρα</td>
        <td>Βασίλειος</td>
        <td>Δημήτριος</td>
        <td>Εριόλα</td>
        <td>Σ. Βασίλειος</td>
    </tr>
    <tr>
        <td colspan="5">Πανεπιστήμιο Μακεδονίας</td>
    </tr>
    <tr colspan="5">
        <td colspan="5">Τμήμα Εφαρμοσμένης Πληροφορικής</td>
    </tr>
</table>
<br>

# Instructions

Here we give instruction about where to download IntelliJ and JavaFX.

## Jetbrains IntelliJ IDEA Setup

You can install IntelliJ IDEA from <a href="https://www.jetbrains.com/idea/">here</a>. If you have an academic email you can download it for free but if you don’t, you can choose the option trial.

This project also includes JavaFx library in order to implement graphical interfaces. IntelliJ IDEA recognizing this and downloads the library automatically. If this don’t happen, you may want to install it manually from <a href="https://openjfx.io/">here</a>.

# Print output sample

<details>
  <summary>

## printData() 
  </summary>


```
> All Jobs in Catalog:
n Name                       Price     
1|Oil change                 |20 €
2|Cabin filter change        |5  €
3|Brake maintenance          |30 €

> All Spare part:
n Name                       Price per unit
1|Oil package 4lt            |30 €
2|Oil filter                 |20 €
3|Cabin filter               |30 €
4|Front wheel brake pad      |5  €
5|Back wheel brake pad       |5  €
6|Break oil                  |10 €

> All Repair File:
n Repair duration in days    Total Cost
1|1                          |105 €
2|2                          |80  €
```

</details>


<details>
  <summary>

## Objected created successful message 

  </summary>
  
```
Ylopoiisi ton zitimaton toy paradotaioy
New Secretary Tampouris has been created

New Secretary Mantas has been created

New Customer Tzhka has been created

New Customer Tsolakidis has been created

New Customer Foulidis has been created

New Customer Hajdari has been created

New Customer Xamalidis has been created

New Vehicle KTR4456 has been created

New ReceptionEngineer Vergidis has been created

New Vehicle NIK3745 has been created

New Job 'Oil change' has been created

New Job 'Cabin filter change' has been created

New Job 'Brake maintenance' has been created

New SparePart 'Oil package 4lt' has been created

New SparePart 'Oil filter' has been created

New SparePart 'Cabin filter' has been created

New SparePart 'Front wheel brake pad' has been created

New SparePart 'Back wheel brake pad' has been created

New SparePart 'Break oil' has been created

New Appointment with customer: CUS2 has been created

New Appointment with customer: CUS2 has been created

New Repairfile with vehicle: KTR4456 has been created

New Repairfile with vehicle KTR4456 has been created

New supervisorEngineer Lee has been created

New Engineer Caephile has been created

New Engineer Cruise has been created

New Assignment in engineer: Martha has been created

New Assignment in engineer: Tom has been created

New Assignment in engineer: Martha has been created
```

</details>

<details>
  <summary>

## Catalog print data 

  </summary>
  
  ```
  Total Catalog contents:
> All Repair Files in catalog:
n Repair duration in days    Status      Plate number   Type        Est Jobs  Assign J  Total Cost
1 |1                         | -         |KTR4456       |Truck      |3        |2        |105 €
2 |2                         | -         |NIK3745       |Car        |3        |1        |80  €

> All Appointments in catalog:
n Date                       Name             Surname         Phone number          Vehicle Plate         Brand                 type                
1 |16/7/2024 - 15:00         |Vasileios       |Tsolakidis     |6996986610           |KTR4456              |TOYOTA               |Truck               
2 |16/7/2024 - 16:00         |Dimitris        |Foulidis       |1234567893           |KTR4456              |TOYOTA               |Truck               

> All Customer data in catalog:
n ID        Name             Surname          Phone Number    Email                 Address             
1 |CUS1     |Dimitra         |Tzhka           |1234567890     |tzhka@gmail.com      |t12345              
2 |CUS2     |Vasileios       |Tsolakidis      |6996986610     |bill@gmail.com       |t12346              
3 |CUS3     |Dimitris        |Foulidis        |1234567893     |jimmy@gmail.com      |t12347              
4 |CUS4     |Erjola          |Hajdari         |1234567894     |eri@gmail.com        |t12348              
5 |CUS5     |Vasileios       |Xamalidis       |1234567895     |bill2@gmail.com      |t12349              

> All Vehicles in catalog:
n Plate Number   Brand     Model                      ProdYear    Vehicle Type   Other Data
1 |KTR4456       |TOYOTA   |90Turbo                   |1989       |Truck       ~ Capacity : 500.0
2 |NIK3745       |Land     |LandRover Range Rover HSE |2014       |Car        

> All data Engineers in catalog:
n ID        Name             Surname          Role      
1 |MHX1     |Konstantinos    |Vergidis        |reception 
2 |MHX2     |Bruce           |Lee             |supervisor
3 |MHX3     |Martha          |Caephile        |engineer  
4 |MHX4     |Tom             |Cruise          |engineer  
  ```
  
</details>

<details>
  <summary>

## Secretary creates a appointment without vehicle 

  </summary>

```
---------- SECRETARY ----------

Secretary surname: bob
Secretary do not exist.
Secretary surname: Mantas
Login as Mantas successful.

Create appointment - 1
Create vehicle - 2
Create customer - 3
Change repairfile status - 4
Print repairfile  - 5
Show Appointments - 6
Update Appointment - 7
Exit - 0
your choice: 1
Search Vehicle - 1
Make Vehicle - 2
Appointment without Vehicle - 3
Exit - 0
your choice: 3
Search Customer - 1
Make Customer - 2
Appointment without Customer - 3
Exit - 0
your choice: 2
Customer name: Konstantinos
Customer surname: Giannoutakis
Customer phone number: 5676512345
Customer email: gkiannou@edu.gr
Customer address: G3 Uni 3roof
Give DateTime (XX/XX/XXXX - XX:XX): 12/05/2023 - 14:00
New Appointment has been created.
Create appointment - 1
Create vehicle - 2
Create customer - 3
Change repairfile status - 4
Print repairfile  - 5
Show Appointments - 6
Update Appointment - 7
Exit - 0
```

  </details>

  <details>
  <summary>

## Reception Engineer adds jobs to repair file 

  </summary>
  
```
---------- Reception Engineer ----------

Engineer user name: Konstantinos
Login as Vergidis successful.

Create Repairfile - 1
Exit - 0
your choice: 1
Search vehicle - 1
Exit - 0
your choice: 1
Vehicle plate number: KTR4456
Choose a Job (1,2,ect...): 
1) Oil change
2) Cabin filter change
3) Brake maintenance
stop adding jobs - 0
your choice: 3
Choose a Job (1,2,ect...): 
1) Oil change
2) Cabin filter change
stop adding jobs - 0
your choice: 2
Choose a Job (1,2,ect...): 
1) Oil change
stop adding jobs - 0
your choice: 1
Choose a Job (1,2,ect...): 
stop adding jobs - 0
your choice: 0
add estimated hours: 7
Create Repairfile - 1
```
  
</details>

<details>
<summary>

## Supervisor assigns jobs to engineers

</summary>

```
---------- Supervisor Engineer ----------

Engineer user name: Bruce
Login as Lee successful

create Assignments - 1
Exit - 0
your choice: 1
Search vehicle by plateNumber - 1
Exit - 0
your choice: 1
Vehicle plateNumber: KTR4456
------------ Set job to engineer ------------
Available engineers:
1) Konstantinos
2) Bruce
3) Martha
4) Tom

Repairfile Jobs:
1) Brake maintenance
2) Cabin filter change
3) Oil change
set job to engineer - 1
add new job - 2
your choice: 1
Choose Job (1,2...): 2
Choose engineer (1,2...): 2
Available engineers:
1) Konstantinos
2) Bruce
3) Martha
4) Tom

Repairfile Jobs:
1) Brake maintenance
2) Cabin filter change -> Bruce
3) Oil change
set job to engineer - 1
add new job - 2
your choice: 3
your choice: 3
your choice: 2
add a job: 1
Available engineers:
1) Konstantinos
2) Bruce
3) Martha
4) Tom

Repairfile Jobs:
1) Brake maintenance
2) Cabin filter change -> Bruce
3) Oil change
4) Cabin filter change
set job to engineer - 1
add new job - 2
your choice: 1
Choose Job (1,2...): 1
Choose engineer (1,2...): 1
```
  
</details>

# Scrum

## Sprint backlog  

![Sprint burndown chart](img/sprintbacklog.png)

## Sprint burndown chart  

![Sprint burndown chart](img/sprintburndownChart.png)


<hr>
<p align="center"> <i> Η παρούσα εργασία υλοποιήθηκε στα πλαίσια του μαθήματος 
<br>
<b> Ανάλυση & Σχεδίαση Συστημάτων </b> 
<br>
4ου εξαμήνου </i> </p> 

<p align="center"> Θεσσαλονίκη 2023  </p> 


<h2>license:</h2>
<hr>
<img align="right" width="15%" height="15%" src="https://i0.wp.com/opensource.org/wp-content/uploads/2009/08/osi_symbol_0.png">

<p> CarOps is available as open source under the terms of <a href="https://github.com/bill-chamal/Car-service-IS/blob/db37606a14da6933994ade9e4c618c37b5444c1f/LICENSE">The MIT License (MIT)</a></p>

<p>Copyright © 2023 CarOps-28.</p>

<p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:</p>

<p>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.</p>

<p>THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</p>

