##Billing & Contracts RESTful Service API
=========================

####Description:

The following application is a RESTful, JSON Contracts and Billing retrieval.  Currently only read-only capabilities are included and the values are hard-coded.  See below for example API calls.

### Pre-requisites
* Maven: version 3.2+
* JDK: version 1.7+
* Internet connection 

#### API Calls:

* [1] Get all contracts for a particular client ID
<blockquote><strong><a href="http://localhost/api/contracts?clientId=1">http://localhost/api/contracts?clientId=1</a></strong></blockquote>
* [2] Get an individual contract matching an enumeration type (service order, service agreement, line item) for a particular client ID<strong><blockquote>
<ul>
    <li><a href="http://localhost/api/contract?clientId=1&type=LINE_ITEM">http://localhost/api/contract?clientId=1&type=LINE_ITEM</a></li>
    <li><a href="http://localhost/api/contract?clientId=1&type=SERVICE_ORDER">http://localhost/api/contract?clientId=1&type=SERVICE_ORDER</a></li>
    <li><a href="http://localhost/api/contract?clientId=1&type=SERVICE_AGREEMENT">http://localhost/api/contract?clientId=1&type=SERVICE_AGREEMENT</a></li>
</ul>
</blockquote></strong>
* [3] Get all invoices for a particular contract ID
<strong><blockquote><a href="http://localhost/api/invoices?contractId=1">http://localhost/api/invoices?contractId=1</a></blockquote></strong>
* [4] Get an individual invoice matching an ID
<strong><blockquote><a href="http://localhost/api/invoice?invoiceId=2">http://localhost/api/invoice?invoiceId=2</a></blockquote></strong>

### Running the application
After downloading the source code from the git repository, execute the following command from a CI shell.

<strong><blockquote>mvn clean install -Dmaven.tomcat.port=80 tomcat:run</blockquote></strong>

This will start the embedded maven-tomcat container on port 80.  You should then be able to test the api calls using curl or a REST client browser plugin.

### Design Notes & Considerations
* The application was created using the following open-source tools & APIs
1) Spring & SpringMVC
2) Jackson REST API
3) Maven
4) Tomcat (runs as an embedded container through maven)

No data persistence framework or Database was used given the time-constraint.  In a real production environment we would've opted to leverage some open-source solution such as MyBatis, Hibernate, TopLink, EclipseLink, etc... along with a relational DB such as MySQL, Oracle, Postgres, etc... or NoSQL (non-relational) DB such as MongoDB, Cassandra, HBase, etc...

Also, I ran out of time to implement tests (which typically I would do first but I wanted to make sure I got it working.  Some tools we would use are:

* Use Spring's MockRestServiceServer
* Use any mocking framework (JMock, EasyMock, Mockito)
* Use mock services running through SoapUI
* Using the the RestTemplate
