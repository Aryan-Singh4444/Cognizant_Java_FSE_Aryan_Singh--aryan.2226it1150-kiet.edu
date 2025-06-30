CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check source account balance
    SELECT balance INTO v_balance
    FROM Accounts
    WHERE account_id = p_from_account
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- Debit source account
    UPDATE Accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    -- Credit destination account
    UPDATE Accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20002, 'Account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/


//Usage Example
BEGIN
    TransferFunds(101, 202, 500);
END;
/
