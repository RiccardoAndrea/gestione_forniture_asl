CREATE OR REPLACE FUNCTION CALCOLO_POTENZA_ANNUO (ANNO CHAR,
DISTRETTO1 CHAR)
RETURN NUMBER IS
POTENZA_TOT NUMBER(8,2);
ANNO_FUTURO EXCEPTION;
DISTRETTO_INESISTENTE CHAR(6);
BEGIN
SELECT DISTRETTO.CODICE_DISTRETTO INTO DISTRETTO_INESISTENTE FROM
DISTRETTO WHERE DISTRETTO.CODICE_DISTRETTO = DISTRETTO1;
IF ANNO>TO_CHAR(SYSDATE,'YYYY') THEN
RAISE ANNO_FUTURO;
END IF;
SELECT SUM(POTENZA_PRELEVATA) INTO POTENZA_TOT
FROM DISTRETTO JOIN STRUTTURA ON STRUTTURA.CODICE_DISTRETTO =
DISTRETTO.CODICE_DISTRETTO
JOIN CONTRATTO ON CONTRATTO.CENTRO_COSTO =
STRUTTURA.CENTRO_COSTO
JOIN BOLLETTA ON CONTRATTO.CIG = BOLLETTA.CIG JOIN BOLLETTA_ELETTRICA
ON BOLLETTA.NUMERO_FATTURA = BOLLETTA_ELETTRICA.NUMERO_FATTURA
WHERE EXTRACT(YEAR FROM BOLLETTA.DATA_EMISSIONE)= ANNO AND
DISTRETTO.CODICE_DISTRETTO = DISTRETTO1;
RETURN POTENZA_TOT;
EXCEPTION
WHEN ANNO_FUTURO THEN
RAISE_APPLICATION_ERROR(-20010,'ANNO ERRATO');
WHEN NO_DATA_FOUND THEN
RAISE_APPLICATION_ERROR(-20011,'DISTRETTO NON ESISTENTE');
RETURN NULL;
END CALCOLO_POTENZA_ANNUO;