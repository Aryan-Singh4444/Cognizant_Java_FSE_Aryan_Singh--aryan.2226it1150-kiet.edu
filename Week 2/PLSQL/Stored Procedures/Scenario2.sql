CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id IN NUMBER,
    p_bonus_pct     IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET salary = salary + (salary * p_bonus_pct / 100)
    WHERE department_id = p_department_id;

    COMMIT;
END;
/


//Usage Example
BEGIN
    UpdateEmployeeBonus(10, 5); -- Gives 5% bonus to dept 10
END;
/
