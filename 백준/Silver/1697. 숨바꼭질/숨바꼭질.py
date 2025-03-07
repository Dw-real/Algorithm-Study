from collections import deque
N, K = map(int, input().split())

q = deque() # 큐 생성
visited = [0] * 100001 # visited 생성
q.append(N) # 시작점 인큐
visited[N] = 1 # 시작점 표시
while q: # 탐색할 위치가 남아있으면
    t = q.popleft() # 탐색 위치 디큐
    if t == K: # 탐색 위치에서 할 일 visit(t). 동생의 위치
        break # while q, 함수인 경우 return visited[t] - 1

    # 인접하고 미방문 위치 확인
    if t - 1 >= 0 and visited[t - 1] == 0:
        q.append(t - 1)
        visited[t - 1] = visited[t] + 1
    if t + 1 <= 100000 and visited[t + 1] == 0:
        q.append(t + 1)
        visited[t + 1] = visited[t] + 1
    if 2 * t <= 100000 and visited[2 * t] == 0:
        q.append(2 * t)
        visited[2 * t] = visited[t] + 1

print(visited[K] - 1)