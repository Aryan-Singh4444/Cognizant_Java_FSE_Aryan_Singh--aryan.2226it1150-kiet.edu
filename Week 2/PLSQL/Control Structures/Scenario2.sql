DECLARE
    CURSOR cur_customers IS
        SELECT customer_id
        FROM Customers
        WHERE balance > 10000;

BEGIN
    FOR rec IN cur_customers LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE customer_id = rec.customer_id;
    END LOOP;

    COMMIT;
END;
/
✅ Explanation:

Iterates through customers with balance above $10,000.

Sets their IsVIP flag to TRUE.

