# 더 이상 업그레이드 할 수 없는 아이템의 ID, 아이템 명, 아이템 희귀도
# 아이템 ID를 기준으로 내림차순
SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO 
WHERE ITEM_ID NOT IN (SELECT PARENT_ITEM_ID
                     FROM ITEM_TREE
                     WHERE PARENT_ITEM_ID IS NOT NULL)
ORDER BY ITEM_ID DESC