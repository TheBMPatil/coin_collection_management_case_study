# Coin Collection Management Case Study

## Problem Statement
Mr. X has been collecting coins over the years and is looking for a way to efficiently manage his collection. The management application should:

1. Allow the user to add individual coins with details such as:
    - Country
    - Denomination
    - Year of minting
    - Current value
    - Acquired date
2. Enable bulk upload of coin data from a file.
3. Provide search functionality with filters, such as:
    - Country
    - Year of minting
    - Current value (sorted)
    - Specific combinations like country + denomination, etc.
4. Persist data in a database, with options to:
    - Load the collection into memory upon application startup.
    - Save the current state of the collection back into the database.

## Approach
The solution is implemented using a modular design with the following layers:

1. **Coin Module**:
    - Represents the Coin entity with attributes like country, denomination, year of minting, etc.
    - Provides methods to manipulate and represent coin data.

2. **DAO (Data Access Object)**:
    - Handles all database interactions such as adding, retrieving, updating, and deleting coin records.
    - Ensures separation of database logic from business logic.

3. **Database Connector**:
    - Manages connections to the MySQL database.
    - Utilizes JDBC for communication with the database.

4. **Service Layer**:
    - Contains business logic, such as validating data, filtering, and sorting.
    - Interfaces between DAO and the main application.

5. **Utility Layer**:
    - Contains reusable helper methods for tasks like input validation and file processing.

6. **Main Application**:
    - Acts as the entry point, providing a menu-driven interface to interact with the user.

### Highlights of the Approach
- **In-Memory Operations**:
    - The application loads data into a collection (e.g., `List<Coin>`) for efficient querying and processing using Java Streams.
- **Separation of Concerns**:
    - The modular design ensures clear boundaries between data access, business logic, and user interaction.
- **Persistence**:
    - Data is loaded from the database at startup and saved back when required, maintaining consistency between the application state and the database.

## Technologies Used
- **Programming Language**: Java (Core Java, Collections, Streams)
- **Database**: MySQL
- **Database Connectivity**: JDBC
- **Development Environment**: IntelliJ IDEA

## Database Structure
The `coin_collection` table in the MySQL database is used to store the coin data. Below is the schema:

```sql
CREATE TABLE coin_collection (
    id INT AUTO_INCREMENT PRIMARY KEY,        -- Unique ID for each coin
    country VARCHAR(50) NOT NULL,             -- Country of the coin
    denomination DECIMAL(10, 2) NOT NULL,     -- Denomination of the coin
    year_of_mint INT NOT NULL,                -- Year the coin was minted
    current_value DECIMAL(10, 2) NOT NULL,    -- Current value of the coin
    acquired_date DATE NOT NULL               -- Date when the coin was acquired
);
```

### Table Description
| Field         | Type          | Null | Key | Default | Extra          |
|---------------|---------------|------|-----|---------|----------------|
| id            | int           | NO   | PRI | NULL    | auto_increment |
| country       | varchar(50)   | NO   | MUL | NULL    |                |
| denomination  | decimal(10,2) | NO   |     | NULL    |                |
| year_of_mint  | int           | NO   | MUL | NULL    |                |
| current_value | decimal(10,2) | NO   |     | 0.00    |                |
| acquired_date | date          | NO   |     | NULL    |                |

### Indexes
Indexes have been added to frequently queried fields to optimize performance:
- `country`
- `year_of_mint`
- `country + denomination`

## Folder Structure
```
coin_collection_management_case_study
├── src
│   ├── com.bm.coinmanagement
│   │   ├── coin
│   │   │   └── Coin.java              // Coin entity class
│   │   ├── dao
│   │   │   └── CoinDAO.java           // Data Access Object for database operations
│   │   ├── dbconnector
│   │   │   └── DbConnector.java       // Database connection handling
│   │   ├── services
│   │   │   └── CoinServices.java      // Business logic layer
│   │   ├── utility
│   │   │   └── Utilities.java         // Reusable helper methods
│   │   └── MainApp.java               // Main application entry point
├── .gitignore                         // Version control configuration
└── coin_collection_management_case_study.iml
```

## Getting Started
1. **Database Setup**:
    - Import the database schema provided above into MySQL.
2. **Application Setup**:
    - Clone the repository and open it in IntelliJ IDEA.
    - Configure the database connection in the `DbConnector` class.
3. **Run the Application**:
    - Execute the `MainApp` class to start the application.

## Future Enhancements
- Add support for exporting the collection to a file (e.g., CSV or Excel).
- Implement a graphical user interface (GUI) for a more user-friendly experience.
- Introduce user authentication for added security.

---
Feel free to reach out for any queries or further assistance!

