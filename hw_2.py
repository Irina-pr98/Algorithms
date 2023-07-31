def heapify(arr, n, i, reverse=False):
    largest = i
    while True:
        left = 2 * i + 1
        right = 2 * i + 2

        if left < n and ((arr[i] < arr[left]) if reverse else (arr[i] > arr[left])):
            largest = left

        if right < n and ((arr[largest] < arr[right]) if reverse else (arr[largest] > arr[right])):
            largest = right

        if largest != i:
            arr[i], arr[largest] = arr[largest], arr[i]
            i = largest
        else:
            break

def heap_sort(arr, reverse=False):
    n = len(arr)

    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i, reverse)

    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0, reverse)

arr = [12, 11, 13, 5, 6, 7, 30, 1, 4, 8]
print("Исходный массив:", arr)

heap_sort(arr)
print("Отсортированный массив (убывание):", arr)

heap_sort(arr, reverse=True)
print("Отсортированный массив (возрастание):", arr)