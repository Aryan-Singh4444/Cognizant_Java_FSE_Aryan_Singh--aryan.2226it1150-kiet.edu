DECLARE
    CURSOR cur_loans IS
        SELECT loan_id, customer_id, due_date
        FROM Loans
        WHERE due_date BETWEEN SYSDATE AND (SYSDATE + 30);

    v_customer_name Customers.name%TYPE;
BEGIN
    FOR rec IN cur_loans LOOP
        -- Fetch customer name for personalization (optional)
        SELECT name INTO v_customer_name
        FROM Customers
        WHERE customer_id = rec.customer_id;

        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_customer_name ||
            ', your loan (ID: ' || rec.loan_id ||
            ') is due on ' || TO_CHAR(rec.due_date, 'DD-MON-YYYY') || '.');
    END LOOP;
END;
/
✅ Explanation:

Fetches all loans due in the next 30 days.

Prints a reminder message with customer name and due date.