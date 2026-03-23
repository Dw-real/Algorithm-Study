# 동물 보호소에 들어온 동물 중, 이름이 없는 채로 들어온 동물의 ID
# ID를 기준으로 오름차순
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL
ORDER BY ANIMAL_ID