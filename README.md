# Assignment Github Repository Name: ayan-chakraborty-pq-assignment
# Application Copyright: Chakraborty, Ayan (ayan.avi@gmail.com)
# Assignment Copyright: Payconiq
# Payconiq Assignment - Stocks Application
 
Application Description:

This is a JVM based backend application build using Springboot REST API. It contains the following end-points:
1. GET /api/stocks (get a list of stocks)
2. POST /api/stocks (create a stock)
3. GET /api/stocks/1 (get one stock from the list)
4. PATCH /api/stocks/1 (update the price of a single stock)
5. DELETE /api/stocks/1 (delete a single stock)

Assignment Description:

1. Build GET /api/stocks which will fetch number of stocks per page which is user configurable.
2. Use Springboot to build and test the application.
3. JUnit Test Cases to be covered.

Framework & Tools Used:

1. Application - Spring framework with Springboot
2. Java - Java v11
3. Database - H2
4. JUnit - JUnit v4
5. Server - Tomcat v9.0

Coding Steps & Functionality:

1. On running the springboot application using Tomcat v9.0 server, springboot loads 'stocks.sql' file automatically which executes the insert queries and builds 'STOCK' table. Currently we have 10 insert queries present in the sql file. So, 10 stocks are generated on application start-up.
2. All database configuration present in application.properties
2. Using JPA Repository mapping, entity class Stock.java is loaded with 'STOCK' table entries.
3. 'StockController' contains the GET API, request payload is sent with the 'Pageable' object class where the number of stocks per page is defined.
4. Request flows from 'StockController' to 'StockHandler'. Using the findAll(pageable) property of 'PagingAndSortingRepository' springframework class, the number of stocks per page is fetched as response.

Application Set-up:

1. Go to Github location: https://github.com/aychakraborty/ayan-chakraborty-pq-assignment
2. Clone Github repository. (https://github.com/aychakraborty/ayan-chakraborty-pq-assignment)
3. Open Eclipse IDE. Go to Git Repository view. Clone application using URL and place it in local directory.
4. Go to Java EE view in Eclipse IDE. Right click on Project Explorer -> Import -> Import as Maven Project and give your local repository location where the project has been cloned from Github.
5. Once import is successful, Run Maven build (clean install) on Eclipse IDE. Make note that you have Java v11 configured and the Maven build is running on jdk 1.11.
6. Once Maven build is successful, perform Maven dependency update. (Right click on project -> Maven -> Update project)
7. Install Tomcat v9.0 server and add to Eclipse IDE. Select jdk 1.11 as your environment run.
8. Add stocks(stocks-0.0.1-SNAPSHOT) to Tomcat server in Eclipse IDE.
9. Double click on Tomcat server. Use port 8080. Increase Timeout to Start 450 s and Stop 150 s.
10. Run Tomcat server with the project. Once server is up, follow below for browser payload testing.

Browser Payload Testing:

Database Verification Local URL: http://localhost:8080/stocks/h2-console/login.jsp - (credentials present in application.properties)

Demo Example #1:

1. Local URL:- http://localhost:8080/stocks/api/stocks?size=2
2. Response:
{
  "content": [
    {
      "name": "Reliance",
      "currentPrice": 2355.6,
      "lastUpdate": "2022-02-06T18:30:01.000+00:00",
      "id": 1
    },
    {
      "name": "TCS",
      "currentPrice": 3742.4,
      "lastUpdate": "2022-02-06T18:30:02.000+00:00",
      "id": 2
    }
  ],
  "pageable": {
    "sort": {
      "empty": true,
      "unsorted": true,
      "sorted": false
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 2,
    "paged": true,
    "unpaged": false
  },
  "totalElements": 10,
  "totalPages": 5,
  "last": false,
  "size": 2,
  "number": 0,
  "sort": {
    "empty": true,
    "unsorted": true,
    "sorted": false
  },
  "first": true,
  "numberOfElements": 2,
  "empty": false
}
3. Result Explanation: As user provide size = 2, 2 stocks are fetched. Total number of pages in this scenario will be 5 as there are 10 stocks and user wanted 2 stocks per page. (Data present in above response)

Demo Example #2:

1. Local URL:- http://localhost:8080/stocks/api/stocks?size=5
2. Response:
{
  "content": [
    {
      "name": "Reliance",
      "currentPrice": 2355.6,
      "lastUpdate": "2022-02-06T18:30:01.000+00:00",
      "id": 1
    },
    {
      "name": "TCS",
      "currentPrice": 3742.4,
      "lastUpdate": "2022-02-06T18:30:02.000+00:00",
      "id": 2
    },
    {
      "name": "HDFC Bank",
      "currentPrice": 1461.1,
      "lastUpdate": "2022-02-06T18:30:03.000+00:00",
      "id": 3
    },
    {
      "name": "Infosys",
      "currentPrice": 1716.55,
      "lastUpdate": "2022-02-06T18:30:04.000+00:00",
      "id": 4
    },
    {
      "name": "ICICI Bank",
      "currentPrice": 792.7,
      "lastUpdate": "2022-02-06T18:30:05.000+00:00",
      "id": 5
    }
  ],
  "pageable": {
    "sort": {
      "empty": true,
      "unsorted": true,
      "sorted": false
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 5,
    "unpaged": false,
    "paged": true
  },
  "totalPages": 2,
  "totalElements": 10,
  "last": false,
  "size": 5,
  "number": 0,
  "sort": {
    "empty": true,
    "unsorted": true,
    "sorted": false
  },
  "first": true,
  "numberOfElements": 5,
  "empty": false
}
3. Result Explanation: As user provide size = 5, 5 stocks are fetched. Total number of pages in this scenario will be 2 as there are 10 stocks and user wanted 5 stocks per page. (Data present in above response)

JUnit Test Case covered for 'StockController' and 'StockHandler' with 100% Unit Test Coverage.