public class LRU缓存机制146 {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2 /* 缓存容量 */ );
		cache.put(2, 1);
		cache.put(1, 2);
		cache.put(2, 3);
		cache.put(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}

}
