/**
 * Consists of classes required to leverage persistence with help of ORMLite framework {@link http://ormlite.com}
 * 
 * Before using persistence in the current app, you need to keep in mind following:
 * <ul>
 * <li> the classes like "Account" (from example) are simple POJOs 
 * <li> each class like "Account" requires a DAO class like "Dao<Account, String>", which is used to create, update, 
 *      find etc. the "Account" 
 * <li> the DAO can be received from DaoManager.createDao(.., Account.class) call
 * <li> register new class type in {@link com.ago.guitartrainer.db.DatabaseConfigUtil}
 * <li> increase DATABASE_VERSION and run the {@link com.ago.guitartrainer.db.DatabaseConfigUtil} each time the entity objects are modified
 * <li> add new line to onCreate() and onUpdate() methods of {@link com.ago.guitartrainer.db.DatabaseConfigUtil}
 * </ul>
 * 
 * 
 * The DatabaseConfigUtil class is to be run with standard (non-android) Java SDK and is there for the purpose of 
 * creating configuration text file, which is used by the ORMLite framework to improve performance of 
 * operations on the persistence layer.
 * 
 */
package com.ago.guitartrainer.db;