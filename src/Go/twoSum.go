package Go

func twoSum(nums []int, target int) []int {
	cnt := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		remain := target - nums[i]
		// _表示占位符
		// 返回两个value, bool(get or not)
		// if ok -> execute
		if _, ok := cnt[remain]; ok {
			return []int{cnt[remain], i}
		}

		cnt[nums[i]] = i
	}

	return []int{-1, -1}
}
