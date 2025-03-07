N = int(input()) # 스위치 개수
arr = list(map(int, input().split())) # 스위치 상태
S = int(input()) # 학생 수
for _ in range(S):
    i, j = map(int, input().split()) # i 성별, j 기준 스위치
    if i == 1:
        # 남학생 작업
        for o in range(j, N+1, j):
            if arr[o - 1] == 1: # 0번 부터로 변환
                arr[o - 1] = 0
            else:
                arr[o - 1] = 1
    else:
        # 여학생 작업
        j -= 1
        for k in range(0, N):
            if 0 <= j - k and j + k < N:
                if arr[j - k] == arr[j + k]:
                    if arr[j - k] == 0:
                        arr[j - k] = arr[j + k] = 1
                    else:
                        arr[j - k] = arr[j + k] = 0
                else: # 대칭이 아닌 경우 중단
                    break # for k

for i in range(N):
    print(arr[i], end = ' ')
    if (i + 1)%20 == 0:
        print()