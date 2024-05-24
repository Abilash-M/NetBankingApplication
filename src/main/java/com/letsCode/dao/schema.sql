USE `NetBankingApplication`;

CREATE TABLE IF NOT EXISTS `AccountDetailsTable` (
  `AccountNumber` INT NOT NULL,
  `AccountHolderName` VARCHAR(45) NULL,
  `PhoneNumber` INT NULL,
  `EmailId` VARCHAR(45) NULL,
  `ResidentialAddress` VARCHAR(45) NULL,
  `ResidentialCity` VARCHAR(45) NULL,
  `NetBankingUserId` VARCHAR(45) NULL,
  `NetBankingPassword` VARCHAR(45) NULL,
  `DateOfBirth` DATE NULL,
  `AccountBalance` INT NULL,
  PRIMARY KEY (`AccountNumber`),
  UNIQUE INDEX `AccountNumber_UNIQUE` (`AccountNumber` ASC) VISIBLE
);

CREATE TABLE IF NOT EXISTS `DebitCreditCardTable` (
  `CardId` INT NOT NULL,
  `AccountNumber` INT NULL,
  `CardNumber` VARCHAR(45) NULL,
  `ExpiryDate` DATE NULL,
  `Cvv` INT NULL,
  `NameOnCard` VARCHAR(45) NULL,
  `ATMPin` INT NULL,
  `CardType` ENUM('Credit', 'Debit') NULL,
  `CreditLimit` INT NULL,
  PRIMARY KEY (`CardId`),
  INDEX `AccountNumber_idx` (`AccountNumber` ASC) VISIBLE,
  CONSTRAINT `DebitCreditCardTable_AccountNumber`
    FOREIGN KEY (`AccountNumber`)
    REFERENCES `AccountDetailsTable` (`AccountNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `TransactionTable` (
  `TransactionId` INT NOT NULL,
  `FromAccountNumber` INT NULL,
  `ToAccountNumber` INT NULL,
  `TransactionValue` INT NULL,
  `TransactionDate` DATE NULL,
  `TransactionType` ENUM('Withdrawal', 'transfer') NULL,
  PRIMARY KEY (`TransactionId`),
  INDEX `FromAccountNumber_idx` (`FromAccountNumber` ASC) VISIBLE,
  INDEX `ToAccountNumber_idx` (`ToAccountNumber` ASC) VISIBLE,
  CONSTRAINT `TransactionTable_FromAccountNumber`
    FOREIGN KEY (`FromAccountNumber`)
    REFERENCES `AccountDetailsTable` (`AccountNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `TransactionTable_ToAccountNumber`
    FOREIGN KEY (`ToAccountNumber`)
    REFERENCES `AccountDetailsTable` (`AccountNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
