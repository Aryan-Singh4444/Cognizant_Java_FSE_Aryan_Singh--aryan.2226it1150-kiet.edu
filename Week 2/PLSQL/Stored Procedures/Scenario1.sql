CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'SAVINGS';

    COMMIT;
END;
/
✅ Explanation:

Updates the balance of all accounts of type SAVINGS by adding 1%.

Commits changes.

