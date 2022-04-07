# Tabcorp-test

**APIs:**

**TASK 1]**
POST: http://localhost:8080/transaction
e.g: 

[{  
    "transactionTime":"2018-01-01",  
    "quantity": "3",  
    "customerId": "10001",  
    "productCode": "PRODUCT_001"  
}, 
{  
    "transactionTime":"2023-01-02",  
    "quantity": "2",  
    "customerId": "10001",  
    "productCode": "PRODUCT_002"  
}, 
{  
    "transactionTime":"2022-01-03",  
    "quantity": "5",  
    "customerId": "10001",  
    "productCode": "PRODUCT_003"  
}, 
{  
    "transactionTime": "2018-01-03",  
    "quantity": "5",  
    "customerId": "10002",  
    "productCode": "PRODUCT_004"  
}, 
{  
    "transactionTime": "2023-01-03",  
    "quantity": "5",  
    "customerId": "10002",  
    "productCode": "PRODUCT_005"  
}, 
{  
    "transactionTime": "2018-01-03",  
    "quantity": "6",  
    "customerId": "10003",  
    "productCode": "PRODUCT_006"  
}, 
{  
    "transactionTime": "2023-01-03",  
    "quantity": "7",  
    "customerId": "10003",  
    "productCode": "PRODUCT_007"  
} , 
{  
    "transactionTime": "2022-01-03",  
    "quantity": "8",  
    "customerId": "10003",  
    "productCode": "PRODUCT_008"  
} , 
{  
    "transactionTime": "2018-01-03",  
    "quantity": "9",  
    "customerId": "10004",  
    "productCode": "PRODUCT_003"  
} , 
{  
    "transactionTime": "2019-01-03",  
    "quantity": "5",  
    "customerId": "10004",  
    "productCode": "PRODUCT_003"  
} , 
{  
    "transactionTime": "2021-01-03",  
    "quantity": "11",  
    "customerId": "10004",  
    "productCode": "PRODUCT_011"  
} , 
{  
    "transactionTime": "2023-01-03",  
    "quantity": "5",  
    "customerId": "10004",  
    "productCode": "PRODUCT_012"  
} , 
{  
    "transactionTime": "2018-01-03",  
    "quantity": "13",  
    "customerId": "10005",  
    "productCode": "PRODUCT_013"  
} , 
{  
    "transactionTime": "2019-01-03",  
    "quantity": "14",  
    "customerId": "10005",  
    "productCode": "PRODUCT_014"  
}, 
{  
    "transactionTime": "2020-01-03",  
    "quantity": "14",  
    "customerId": "10005",  
    "productCode": "PRODUCT_014"  
} , 
{  
    "transactionTime": "2021-01-03",  
    "quantity": "14",  
    "customerId": "10005",  
    "productCode": "PRODUCT_014"  
}, 
{  
    "transactionTime": "2023-01-03",  
    "quantity": "14",  
    "customerId": "10005",  
    "productCode": "PRODUCT_014"  
}  
]

**TASK 3]**
Total cost of transactions per customer :
GET: http://localhost:8080/customer-cost

Total cost of transactions per product:
GET: http://localhost:8080/aus-transactions

Number of transactions sold to customer from Australia :
GET: http://localhost:8080/product-cost


