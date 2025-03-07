arr = []

for _ in range(9):
    arr.append(int(input()))

max_v = arr[0]
max_index = 1

for i in range(0, 9):
    if max_v < arr[i]:
        max_v = arr[i]
        max_index = i + 1

print(max_v)
print(max_index)
