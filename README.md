# zoomdata

#How to run

To run by default (in Firefox) all tests from maven, just type from command line:

mvn clean test 

(optionally) mvn clean test -Dbrowser=firefox

To run tests in Chrome, type:

mvn clean test -Dbrowser=chrome

To run one test class, type:

mvn clean -Dtest=com.zoomdata.demo.Donut

#Info 

Also for testing canvas was implemented like storage screenshots.

There are following folders in the project which responsible to keep expected, actual and difference screenshots :

Folder : "ActualCharts" keeps actual screenshots in different Data Source folders : "impala_automation","mysql_automation"

Folder : "DiffCharts" keeps screenshots with marked difference Data Source folders : "impala_automation","mysql_automation"

Folder : "ExpectedCharts" keeps actual screenshots in different Data Source folders : "impala_automation","mysql_automation"

