create or replace FUNCTION FUNZIONE_DI_HASHING(
nums IN NUMBER,
ch_sp IN NUMBER,
ch_min IN NUMBER,
ch_maiusc IN NUMBER) return varchar2
IS
lun number := nums + ch_sp + ch_min + ch_maiusc;
pw varchar2(200);
v_iterations number := 0;
max_iter number := 500;
BEGIN
loop
pw := dbms_random.string('p',lun);
v_iterations := v_iterations + 1;
exit when (regexp_count(pw,'[a-z]') = ch_min
and regexp_count(pw,'[A-Z]') = ch_maiusc
and regexp_count(pw,'[0-9]') = nums)
or v_iterations=max_iter;
end loop;
if v_iterations = max_iter THEN
pw := '';
end if;
return(pw);
END;