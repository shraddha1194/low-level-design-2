package org.lld.designPatterns.creational.builder.database;

import lombok.Getter;

@Getter
public class Database {
    private String name;
    private String userName;
    private String password;
    private Integer port;
    private DatabaseType type;
    private Boolean isCompressed;

    private  Database() {}

    // Trick 1 - Builder method
    public static Builder builder() {
        return new Builder();
    }

    /* Step 1 - create static inner class
     friend class has complete access to main class
     we call private constructors, private methods and attributes in this class
     */

    public static class Builder {
        // Step 2 - copy all the fields from the outer class
        private String name;
        private String userName;
        private String password;
        private Integer port;
        private DatabaseType type;
        private Boolean isCompressed;

        /* Step 3 - create setters for our builder
         trick 2 - create fluent interfaces make setters return this object - so we can chain method calls
         when we create setters with name of param - looks nice, more readable */

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder withCredential(String userName, String password) {
            this.userName = userName;
            this.password = password;
            return this;
        }

        public Builder port(Integer port) {
            this.port = port;
            return this;
        }

        public Builder mysql() {
            this.type = DatabaseType.MYSQL;
            return this;
        }

        public Builder compressed() {
            this.isCompressed = true;
            return this;
        }

        // Step 4 - Create a build method to return the outer class object
        public Database build() {
            if (!isValid()) {
                throw new IllegalArgumentException("Invalid database configuration!");
            }

            Database database = new Database();
            database.name = this.name;
            database.port = this.port;
            database.userName = this.userName;
            database.password = this.password;
            database.isCompressed = this.isCompressed;
            database.type = this.type;
            return database;
        }

        // Step 5 - Add a validation method
        public Boolean isValid() {
            if (this.name == null) {
                return false;
            }

            if (this.type == DatabaseType.MYSQL && this.port != 3306) {
                return false;
            }
            return true;
        }
    }
}
