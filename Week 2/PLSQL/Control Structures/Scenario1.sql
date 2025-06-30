DECLARE
    CURSOR cur_customers IS
        SELECT customer_id
        FROM Customers
        WHERE age > 60;

BEGIN
    FOR rec IN cur_customers LOOP
        UPDATE Loans
        SET interest_rate = interest_rate - 1
        WHERE customer_id = rec.customer_id;
    END LOOP;

    COMMIT;
END;
/
✅ Explanation:

This cursor loops through all customers over 60.

For each customer, it updates their loan interest rate, reducing it by 1%.

