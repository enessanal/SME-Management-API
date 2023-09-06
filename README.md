# Small and Medium-Sized Enterprise Management
A practical api designed for SMEs, focusing on their unique operational needs. Recognizing the distinct and non-standard demands of SMEs, this API simplifies product and customer management, provides custom pricing, and simplify sales, invoicing, and delivery processes.

*SME-Management API is being specifically designed for an SME. It can be customized for companies with different requirements under new tags.*

## Reference Repositories
* https://github.com/esaddag/catalog-api
* https://github.com/esaddag/product-list

## Table of Contents

<!-- - [Installation](#installation) -->
<!-- - [Usage](#usage) -->
- [Module List](#module-list)
- [Modules' Progress Tracking](#progress-tracking)
<!-- - [Planned Features](#planned-features) -->
<!-- - [Completed Features](#completed-features) -->
<!-- - [Modules](#modules) -->

<!-- - [License](#license) -->

## Module List

| Modules				| Description 																	|
|-----------------------|-------------------------------------------------------------------------------|
| Customer Management	| CRUD operations, Bulk operations. 3rd party software's integrations.			|
| Employee Management		| CRUD operations, Bulk operations.												|
| Employee Role Management	| Authorization and privileges. (Accounting, Sale, Manager, Admin etc.)			|
| Product Management	| CRUD Operations, Bulk operations. Detailed logging. Permission management.	|
| Price Customization	| Dynamic pricing. Brand-specific, category-specific factors.					|
| Sale Operations		| Cart to sale, sale to invoice, sale management etc.							|
| Contract Management	| Statistics, reports, charts etc.												|
| Delivery Management	| Reminders, notifications.														|

## Progress Tracking
### Customer Management
- #### Completed Features
	- [x] ***Get Customers List***
	- [x] ***Get Customer by ID***
	- [x] ***Get Customer by Code***
	- [x] ***Get Customer by Identity Number***
 	- [x] ***Count Customers***
	- [x] ***Delete Customer By Id***
	- [x] ***Delete Customer By Code***
	- [x] ***Delete Customer By Identity Number***

	- [x] ***Get Address List of a Customer***
	- [x] ***Get an Address of a Customer By Id***
	- [x] ***Add Customer Address***
	- [x] ***Delete Customer Addresses***


### Product Management
- #### Completed Features
	- [x] ***Get Products List***
    - [x] ***Get Product by ID***


### Planned Features
- [ ] Patch Customers Fields
- [ ] Customer Add
- [ ] Filter Customers by;
	- [ ] Full Name
	- [ ] City
	- [ ] Address
- [ ] Address add
- [ ] Address update (PUT)
- [ ] Async Bulk Update Products' Prices When a Brand's Rate Changed.
- [ ] Export Product List to excel file.
- [ ] Import Product List from excel file.
- [ ] Product changes log management
- [ ] Multi Language for error messages.




---

```
Things to consider when importing products from Excel.
 - Filters to apply when retrieving string values:
 	-> TRIM(), removing all unnecessary spaces.
 	-> NewLine characters must be removed (SUBSTITUTE(SUBSTITUTE(TRIM([@name]); CHAR(10); "");CHAR(13); ""))
 	-> Product code cannot contain space character.
 	-> Product code will not contain Turkish characters.
 	-> Size field standardization.
 	-> Prevent chars like ",.' etc." for all string fields especially code, category etc.
```











 
	
