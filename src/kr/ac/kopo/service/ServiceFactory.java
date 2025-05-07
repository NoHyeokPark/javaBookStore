package kr.ac.kopo.service;

public class ServiceFactory {
	private static MemberService loginService;
	private static SearchService searchService;
	private static CSService csService;
	private static OrderService orderService;
	private static CashService cashService;
	private static AddressService addService;
	private static BucketService bucketService;
	private static BookReviewService reviewService;
	private static ReadingService readingService;

	public static MemberService getMemberInstance() {
		if(loginService == null)
			loginService = new MemberService();
		return loginService;
	}
	
	public static SearchService getSearchInstance() {
		if(searchService == null)
			searchService = new SearchService();
		return searchService;
	}
	
	public static CSService getCSInstance() {
		if(csService == null)
			csService = new CSService();
		return csService;
	}
	
	public static OrderService getOrderInstance() {
		if(orderService == null)
			orderService = new OrderService();
		return orderService;
	}
	
	public static CashService getCashInstance() {
		if(cashService == null)
			cashService = new CashService();
		return cashService;
	}
	
	public static AddressService getAddressInstance() {
		if(addService == null)
			addService = new AddressService();
		return addService;
	}
	
	public static BucketService getBucketInstance() {
		if(bucketService == null)
			bucketService = new BucketService();
		return bucketService;
	}
	
	public static BookReviewService getReviewInstance() {
		if(reviewService == null)
			reviewService = new BookReviewService();
		return reviewService;
	}
	
	public static ReadingService getReadingInstance() {
		if(readingService == null)
			readingService = new ReadingService();
		return readingService;
	}
	
}
