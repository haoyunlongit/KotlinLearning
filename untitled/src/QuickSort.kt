class QuickSort {
    fun quickSort(nums: IntArray): IntArray {
        nums?.run {
            doSort(nums, 0, nums.size - 1)
        }
        return nums
    }

    fun doSort(nums: IntArray, left: Int, right: Int) {
        if (left >= right) {
            return
        }

        var l: Int = left
        var r: Int = right
        var target = nums[left]
        while (l < r) {
            while (nums[r] >= target && l < r) {
                r--
            }
            nums[l] = nums[r]

            while (nums[l] < target && l < r) {
                l++
            }
            nums[r] = nums[l]
        }

        nums[l] = target
        doSort(nums, left, l -1)
        doSort(nums, l+1, right);
    }
}

fun main() {

}