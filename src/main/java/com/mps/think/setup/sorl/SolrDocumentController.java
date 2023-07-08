package com.mps.think.setup.sorl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.*;
import com.mps.think.setup.repo.DeliveryMethodOverridesRepo;
import com.mps.think.setup.repo.MakePaymentRepo;
import com.mps.think.setup.service.AddEffortService;
import com.mps.think.setup.service.AddOrderService;
import com.mps.think.setup.service.AddPaymentService;
import com.mps.think.setup.service.AddProcessService;
import com.mps.think.setup.service.AddressService;
import com.mps.think.setup.service.AddressStatusService;
import com.mps.think.setup.service.AddressessService;
import com.mps.think.setup.service.AutoRenewalService;
import com.mps.think.setup.service.AuxService;
import com.mps.think.setup.service.CancelOrderService;
import com.mps.think.setup.service.CancelReasonsService;
import com.mps.think.setup.service.CommodityCodesService;
import com.mps.think.setup.service.CountriesService;
import com.mps.think.setup.service.CreditStatusService;
import com.mps.think.setup.service.CurrencyExchangeService;
import com.mps.think.setup.service.CustomerCategoryService;
import com.mps.think.setup.service.CustomerDetailsService;
import com.mps.think.setup.service.DeliveryMethodOverridesService;
import com.mps.think.setup.service.DeliveryMethodsService;
import com.mps.think.setup.service.DiscountCardKeyInfoService;
import com.mps.think.setup.service.EffectiveDatesForDiscountService;
import com.mps.think.setup.service.ExtractFilterService;
import com.mps.think.setup.service.InsertService;
import com.mps.think.setup.service.InventoryService;
import com.mps.think.setup.service.InvoiceEmailsTempletService;
import com.mps.think.setup.service.IssueGenerationService;
import com.mps.think.setup.service.IssueSettingsService;
import com.mps.think.setup.service.JobQueueService;
import com.mps.think.setup.service.JurisdictionsService;
import com.mps.think.setup.service.LableFormatGroupsService;
import com.mps.think.setup.service.LableFormatService;
import com.mps.think.setup.service.LableGroupService;
import com.mps.think.setup.service.LableKeyLineService;
import com.mps.think.setup.service.MakePaymentService;
import com.mps.think.setup.service.NthService;
import com.mps.think.setup.service.OrderCategoryService;
import com.mps.think.setup.service.OrderClassOverviewService;
import com.mps.think.setup.service.OrderClassService;
import com.mps.think.setup.service.OrderCodesService;
import com.mps.think.setup.service.OrderThresholdInfoService;
import com.mps.think.setup.service.OutputSortService;
import com.mps.think.setup.service.OutputValueService;
import com.mps.think.setup.service.ParentChildMappingService;
import com.mps.think.setup.service.PaymentInformationService;
import com.mps.think.setup.service.PaymentLinkStatusService;
import com.mps.think.setup.service.PaymentThresholdService;
import com.mps.think.setup.service.PaymentTypeService;
import com.mps.think.setup.service.ProcessOutputService;
import com.mps.think.setup.service.ProcessTypeService;
import com.mps.think.setup.service.ProfitCenterService;
import com.mps.think.setup.service.PublisherSerivce;
import com.mps.think.setup.service.QueueService;
import com.mps.think.setup.service.RCEffortRangeService;
import com.mps.think.setup.service.RateCardsRenewalsService;
import com.mps.think.setup.service.RateCardsService;
import com.mps.think.setup.service.RenewalCardService;
import com.mps.think.setup.service.RenewalDefinitionService;
import com.mps.think.setup.service.RenewalOfferDetailsService;
import com.mps.think.setup.service.RentalStatusService;
import com.mps.think.setup.service.RepeatingService;
import com.mps.think.setup.service.SalesRepresentativeService;
import com.mps.think.setup.service.ShippingMethodService;
import com.mps.think.setup.service.ShippingPriceListService;
import com.mps.think.setup.service.SourceAttributeValuesService;
import com.mps.think.setup.service.SourceAttributesService;
import com.mps.think.setup.service.SourceCodeService;
import com.mps.think.setup.service.SourceFormatSegmentService;
import com.mps.think.setup.service.SourceFormatService;
import com.mps.think.setup.service.SpecialTaxIdsService;
import com.mps.think.setup.service.SplitsService;
import com.mps.think.setup.service.SubmitJobService;
import com.mps.think.setup.service.SubscriptionCategoryService;
import com.mps.think.setup.service.SubscriptionDefKeyInfoService;
import com.mps.think.setup.service.SuspendOrderService;
import com.mps.think.setup.service.TaxRateCategoryService;
import com.mps.think.setup.service.TaxService;
import com.mps.think.setup.service.TaxonomyService;
import com.mps.think.setup.service.TermsService;
import com.mps.think.setup.service.TransportModeService;
import com.mps.think.setup.service.UnitBasedSubscriptionService;
import com.mps.think.setup.service.ValueForScAttributeService;
import com.mps.think.setup.service.VolumeGroupService;
import com.mps.think.setup.utils.ScheduledTask;
import com.mps.think.setup.vo.CustomerOrderPaymentMakePaymentInfo;
import com.mps.think.setup.vo.CustomerSolrVO;
import com.mps.think.setup.vo.MakePaymentSolrVO;
import com.mps.think.setup.vo.OrderSolrVO;
import com.mps.think.setup.vo.PaymentInfoSolrVO;

/**
 * Created by @rohit.
 */
@RestController
@CrossOrigin
@Component
public class SolrDocumentController {
	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private DocumentRepository1 documentRepository1;
	
	@Autowired
	private DocumentRepository2 documentRepository2;
	
	@Autowired
	private AddOrderService orderService;
	
	@Autowired
	private DocumentRepository3 documentRepository3;

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private AddressessService addressessService;

	@Autowired

	private AddEffortService addEffortService;

	@Autowired
	private AddPaymentService addPaymentService;

	@Autowired
	private AddProcessService addProcessService;

	@Autowired
	private AutoRenewalService autoRenewalService;

	@Autowired
	private AuxService auxService;

	@Autowired
	private CancelOrderService cancelOrderService;

	@Autowired
	private CancelReasonsService cancelReasonsService;

	@Autowired
	private CommodityCodesService commodityCodesService;

	@Autowired
	private CreditStatusService creditStatusService;

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@Autowired
	private CustomerCategoryService customerCategoryService;

	@Autowired
	private DeliveryMethodOverridesService deliveryMethodOverridesService;

	@Autowired
	private DeliveryMethodsService DeliveryMethodsService;

	@Autowired
	private DiscountCardKeyInfoService discountCardKeyInfoService;

	@Autowired
	private EffectiveDatesForDiscountService EffectiveDatesForDiscountService;

	@Autowired
	private ExtractFilterService extractFilterService;

	@Autowired
	private InsertService insertService;

	@Autowired
	private InvoiceEmailsTempletService InvoiceEmailsTempletService;

	@Autowired
	private IssueGenerationService issueGenerationService;

	@Autowired
	private IssueSettingsService IssueSettingsService;

	@Autowired
	private JobQueueService jobQueueService;

	@Autowired
	private JurisdictionsService JurisdictionsService;

	@Autowired
	private LableFormatService LableFormatService;

	@Autowired
	private LableFormatGroupsService lableFormatGroupsService;

	@Autowired
	private LableGroupService LableGroupService;

	@Autowired
	private LableKeyLineService lableKeyLineService;

	@Autowired
	private MakePaymentService MakePaymentService;

	@Autowired
	private NthService NthService;

	@Autowired
	private AddOrderService AddOrderService;

	@Autowired
	private OrderCategoryService orderCategoryService;

	@Autowired
	private OrderClassService OrderClassService;

	@Autowired
	private OrderClassOverviewService OrderClassOverviewService;

	@Autowired
	private OrderCodesService orderCodesService;

	@Autowired
	private SuspendOrderService SuspendOrderService;

	@Autowired
	private OrderThresholdInfoService orderThresholdInfoService;

	@Autowired
	private OutputSortService outputSortService;

	@Autowired
	private OutputValueService outputValueService;

	@Autowired
	private ParentChildMappingService parentChildMappingService;

	@Autowired
	private PaymentInformationService paymentInformationService;

	@Autowired
	private PaymentLinkStatusService paymentLinkStatusService;

	@Autowired
	private PaymentThresholdService paymentThresholdService;

	@Autowired
	private PaymentTypeService paymentTypeService;

	@Autowired
	private ProcessOutputService processOutputService;

	@Autowired
	private ProcessTypeService ProcessTypeService;

	@Autowired
	private ProfitCenterService profitCenterService;

	@Autowired
	private PublisherSerivce publisherSerivce;

	@Autowired
	private QueueService QueueService;

	@Autowired
	private RateCardsService rateCardsService;

	@Autowired
	private RateCardsRenewalsService rateCardsRenewalsService;

	@Autowired
	private RCEffortRangeService rCEffortRangeService;

	@Autowired
	private RenewalCardService renewalCardService;

	@Autowired
	private RenewalDefinitionService renewalDefinitionService;

	@Autowired
	private RenewalOfferDetailsService renewalOfferDetailsService;

	@Autowired
	private RentalStatusService rentalStatusService;

	@Autowired
	private RepeatingService repeatingService;

	@Autowired
	private SalesRepresentativeService salesRepresentativeService;

	@Autowired
	private ShippingMethodService shippingMethodService;

	@Autowired
	private ShippingPriceListService shippingPriceListService;

	@Autowired
	private SourceAttributesService sourceAttributesService;

	@Autowired
	private SourceAttributeValuesService sourceAttributeValuesService;

	@Autowired
	private SourceCodeService sourceCodeService;

	@Autowired
	private SourceFormatService sourceFormatService;

	@Autowired
	private SourceFormatSegmentService sourceFormatSegmentService;

	@Autowired
	private SpecialTaxIdsService specialTaxIdsService;

	@Autowired
	private SplitsService splitsService;

	@Autowired
	private SubmitJobService submitJobService;

	@Autowired
	private SubscriptionCategoryService subscriptionCategoryService;

	@Autowired
	private SubscriptionDefKeyInfoService subscriptionDefKeyInfoService;

	@Autowired
	private SuspendOrderService suspendOrderService;

	@Autowired
	private TaxonomyService taxonomyService;

	@Autowired
	private TaxRateCategoryService taxRateCategoryService;

	@Autowired
	private TaxService taxService;

	@Autowired
	private TermsService termsService;

	@Autowired
	private TransportModeService transportModeService;

	@Autowired
	private UnitBasedSubscriptionService unitBasedSubscriptionService;

	@Autowired
	private ValueForScAttributeService valueForScAttributeService;

	@Autowired
	private VolumeGroupService VolumeGroupService;

	@Autowired
	private CountriesService countriesService;

	@Autowired
	private AddressStatusService addressStatusService;

	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	ScheduledTask checkSCTask;
	
	@Autowired
	ObjectMapper mapper;

  @Autowired
  private SolrClient solrClient;
  
  
  @GetMapping("/checkTasks")
  public String checkTasks() {
	  checkSCTask.runSolrTask();
	  return "done";
  }
	
	@RequestMapping("/")
	public String SpringBootSolrExample() {
		return "Welcome to Spring Boot solr Example";
	}

	@GetMapping("/delete")
	public String deleteAllDocuments() {
		try { // delete all documents from solr core
			documentRepository.deleteAll();
			return "documents deleted succesfully!";
		} catch (Exception e) {
			return "Failed to delete documents";
		}
	}

	@GetMapping("/save")
	public String saveAllDocuments() {
		// Store Documents
		documentRepository.saveAll(Arrays.asList(new Document("1", "pdf", "Java Dev Zone"),
				new Document("2", "msg", "subject:reinvetion"), new Document("3", "pdf", "Spring boot sessions"),
				new Document("4", "docx", "meeting agenda"), new Document("5", "docx", "Spring boot + solr")));
		return "5 documents saved!!!";
	}

	

	@GetMapping("/solrSearched/{keyword}")
	public List<String> searchDocTitles(String keyword) throws Exception {
		SolrQuery query = new SolrQuery();
		query.setQuery("id:*" + keyword + "*");
		query.setFields("docTitle");

		QueryResponse response = solrClient.query(query);
		SolrDocumentList results = response.getResults();

		List<String> docTitles = new ArrayList<String>();
		for (SolrDocument doc : results) {
			docTitles.add((String) doc.getFieldValue("docTitle"));
		}

		return docTitles;
	}

	@GetMapping("/getAll")
	public List<Document> getAllDocs() {
		List<Document> documents = new ArrayList<>();
		// iterate all documents and add it to list
		for (Document doc : this.documentRepository.findAll()) {
			documents.add(doc);
		}
		return documents;
	}

	@GetMapping("/saveCustomerDetails")
	public String CustomerDetailsDocuments() throws Exception {
		// Store Documents
		List<CustomerDetails> cust = customerDetailsService.getAllCustomerDetails();
		for (CustomerDetails customerDetails : cust) {
//			String customerWithOrders = customerDetails.toString();
//			List<String> customersOrder = orderService.getAllOrderByCustomerId(customerDetails.getCustomerId(), PageRequest.of(0, Integer.MAX_VALUE)).toList()
//					.stream().map(o->o.toString()).collect(Collectors.toList());
//			customerWithOrders = customerWithOrders.concat(customersOrder.toString());
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			CustomerOrderPaymentMakePaymentInfo cs = new CustomerOrderPaymentMakePaymentInfo();
			
			cs.setCustomer(Arrays.asList(mapper.convertValue(customerDetails, CustomerSolrVO.class)));
			cs.setOrders(orderService.getAllOrderByCustomerId(customerDetails.getCustomerId(), PageRequest.of(0, Integer.MAX_VALUE))
					.stream().map(o -> mapper.convertValue(o, OrderSolrVO.class)).collect(Collectors.toList()));
			cs.setPaymentInfos(paymentInformationService.getallPaymentInformationForCustomer(customerDetails.
					getCustomerId(), PageRequest.of(0, Integer.MAX_VALUE)).stream().
					map(p -> mapper.convertValue(p, PaymentInfoSolrVO.class)).collect(Collectors.toList()));
			cs.setPaymentAccounts(MakePaymentService.getallPaymentAccountForCustomer(customerDetails.
					getCustomerId(), PageRequest.of(0, Integer.MAX_VALUE)).stream().
					map(m -> mapper.convertValue(m, MakePaymentSolrVO.class)).collect(Collectors.toList()));

			documentRepository1.save(new Document1("CustomerDetails" + customerDetails.getCustomerId(),
					"customer" + customerDetails.getCustomerId(), cs.toString(),
					objectMapper.writeValueAsString(cs)));
		}
		return "CustomerDetails saved!!!";
	}
	
	@GetMapping("/saveOrderSolr")
	public String OrderDocuments() throws JsonProcessingException {
	    List<Order> o = AddOrderService.getAllOrder();
	    for (Order order : o) {
	        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	        CustomerOrderPaymentMakePaymentInfo allInfo = new CustomerOrderPaymentMakePaymentInfo();
	        OrderSolrVO orderSolrVO = mapper.convertValue(order, OrderSolrVO.class);
	        allInfo.setOrders(Arrays.asList(orderSolrVO));
	        allInfo.setCustomer(Arrays.asList(mapper.convertValue(order.getCustomerId(), CustomerSolrVO.class)));
	        allInfo.setPaymentInfos(paymentInformationService.getPaymentInformationByOrderId(order.getOrderId(), PageRequest.of(0, Integer.MAX_VALUE))
	                .stream().map(p -> mapper.convertValue(p, PaymentInfoSolrVO.class)).collect(Collectors.toList()));
	        allInfo.setPaymentAccounts(MakePaymentService.findAllMakePaymentForOrder(order.getOrderId()).stream()
	                .map(m -> mapper.convertValue(m, MakePaymentSolrVO.class)).collect(Collectors.toList()));

	        documentRepository2.save(new Document2("Order" + order.getOrderId(), "Order" + order.getOrderId(),
	                allInfo.toString(), objectMapper.writeValueAsString(allInfo)));
	    }
	    return "Order saved!!!";
	}

	

	@GetMapping("/savePaymentInformationSolr")
	public String PaymentInformationDocuments() throws JsonProcessingException {
		List<PaymentInformation> pi = paymentInformationService.getAllPaymentInformation();
		for (PaymentInformation paymentInformation : pi) {
			
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			CustomerOrderPaymentMakePaymentInfo allInfo = new CustomerOrderPaymentMakePaymentInfo();
			Order order = paymentInformation.getOrder();
			allInfo.setPaymentInfos(Arrays.asList(mapper.convertValue(paymentInformation, PaymentInfoSolrVO.class)));
			allInfo.setPaymentAccounts(MakePaymentService.findAllMakePaymentForOrder(order.getOrderId()).stream().
					map(m -> mapper.convertValue(m, MakePaymentSolrVO.class)).collect(Collectors.toList()));
			allInfo.setOrders(Arrays.asList(mapper.convertValue(order, OrderSolrVO.class)));
			allInfo.setCustomer(Arrays.asList(mapper.convertValue(order.getCustomerId(), CustomerSolrVO.class)));
			
			documentRepository3.save(new Document3("PaymentInformation" + paymentInformation.getId(),
					"PaymentInformation" + paymentInformation.getId(), allInfo.toString(),
					objectMapper.writeValueAsString(allInfo)));
		}

		return "PaymentInformation saved!!!";
	}
	

	@GetMapping("/saveCustomerAddressesSolr")
	public String CustomerAddressesDocuments() throws JsonProcessingException {
		// Store Documents
		List<CustomerAddresses> custAdd = customerDetailsService.getAllCustomerAddresses();
		for (CustomerAddresses customerAddresses : custAdd) {
			documentRepository.save(new Document("CustomerAddresses" + customerAddresses.getId(),
					"customer" + customerAddresses.getId(), customerAddresses.toString(),
					objectMapper.writeValueAsString(customerAddresses)));
		}

		return "CustomerAddresses saved!!!";
	}

	@GetMapping("/saveAddressesSolr")
	public String AddressesDocuments() throws JsonProcessingException {
		List<Addresses> add = addressService.getAllAddresses();
		for (Addresses addresses : add) {
			documentRepository
					.save(new Document("Addresses" + addresses.getAddressId(), "Addresses" + addresses.getAddressId(),
							addresses.toString(), objectMapper.writeValueAsString(addresses)));
		}

		return "Addresses saved!!!";
	}

	@GetMapping("/saveAddEffortSolr")
	public String AddEffortDocuments() throws JsonProcessingException {
		List<AddEffort> ae = addEffortService.getAllAddEffort();
		for (AddEffort addEffort : ae) {
			documentRepository.save(new Document("AddEffort" + addEffort.getId(), "Effort" + addEffort.getId(),
					addEffort.toString(), objectMapper.writeValueAsString(addEffort)));
		}

		return "AddEffort saved!!!";
	}

	@GetMapping("/saveAddPaymentSolr")
	public String AddPaymentDocuments() throws JsonProcessingException {
		List<AddPayment> ap = addPaymentService.getAllAddPayment();
		for (AddPayment addPayment : ap) {
			documentRepository.save(new Document("AddPayment" + addPayment.getId(), "AddPayment" + addPayment.getId(),
					addPayment.toString(), objectMapper.writeValueAsString(addPayment)));
		}

		return "AddPayment saved!!!";
	}

	@GetMapping("/saveAddProcessSolr")
	public String AddProcessDocuments() throws JsonProcessingException {
		List<AddProcess> apr = addProcessService.getAllProcess();
		for (AddProcess addProcess : apr) {
			documentRepository.save(new Document("AddProcess" + addProcess.getId(), "AddProcess" + addProcess.getId(),
					addProcess.toString(), objectMapper.writeValueAsString(addProcess)));
		}

		return "AddProcess saved!!!";
	}

	@GetMapping("/saveAutoRenewalSolr")
	public String AutoRenewalDocuments() throws JsonProcessingException {
		List<AutoRenewal> arnl = autoRenewalService.getAllAutoRenewal();
		for (AutoRenewal autoRenewal : arnl) {
			documentRepository
					.save(new Document("AutoRenewal" + autoRenewal.getId(), "AutoRenewal" + autoRenewal.getId(),
							autoRenewal.toString(), objectMapper.writeValueAsString(autoRenewal)));
		}

		return "AutoRenewal saved!!!";
	}

	@GetMapping("/saveAuxVariableSolr")
	public String AuxVariableDocuments() throws JsonProcessingException {
		List<AuxVariable> aux = auxService.getAllAuxVariable();
		for (AuxVariable auxVariable : aux) {
			documentRepository.save(
					new Document("AuxVariable" + auxVariable.getAuxVarId(), "auxVariable" + auxVariable.getAuxVarId(),
							auxVariable.toString(), objectMapper.writeValueAsString(auxVariable)));
		}

		return "AuxVariable saved!!!";
	}

	@GetMapping("/saveCancelOrderSolr")
	public String CancelOrderDocuments() throws JsonProcessingException {
		List<CancelOrder> co = cancelOrderService.getAllCancelOrder();
		for (CancelOrder cancelOrder : co) {
			documentRepository.save(new Document("CancelOrder" + cancelOrder.getCancelorderId(),
					"CancelOrder" + cancelOrder.getCancelorderId(), cancelOrder.toString(),
					objectMapper.writeValueAsString(cancelOrder)));
		}

		return "CancelOrder saved!!!";
	}

	@GetMapping("/saveCancelReasonsSolr")
	public String CancelReasonsDocuments() throws JsonProcessingException {
		List<CancelReasons> cr = cancelReasonsService.getAllCancelReasons();
		for (CancelReasons cancelReasons : cr) {
			documentRepository.save(new Document("CancelReasons" + cancelReasons.getCancelReasonsId(),
					"CancelReasons" + cancelReasons.getCancelReasonsId(), cancelReasons.toString(),
					objectMapper.writeValueAsString(cancelReasons)));
		}

		return "CancelReasons saved!!!";
	}

	@GetMapping("/saveCommodityCodesSolr")
	public String CommodityCodesDocuments() throws JsonProcessingException {
		List<CommodityCodes> cc = commodityCodesService.getAllCommodityCodes();
		for (CommodityCodes commodityCodes : cc) {
			documentRepository.save(
					new Document("CommodityCodes" + commodityCodes.getId(), "CommodityCodes" + commodityCodes.getId(),
							commodityCodes.toString(), objectMapper.writeValueAsString(commodityCodes)));
		}

		return "CommodityCodes saved!!!";
	}

	@GetMapping("/saveCreditStatusSolr")
	public String CreditStatusDocuments() throws JsonProcessingException {
		List<CreditStatus> cc = creditStatusService.getAllCreditStatus();
		for (CreditStatus creditStatus : cc) {
			documentRepository.save(new Document("CreditStatus" + creditStatus.getCreditId(),
					"CreditStatus" + creditStatus.getCreditId(), creditStatus.toString(),
					objectMapper.writeValueAsString(creditStatus)));
		}

		return "CreditStatus saved!!!";
	}

	@GetMapping("/saveCurrencyExchangeSolr")
	public String CurrencyExchangeDocuments() throws JsonProcessingException {
		List<CurrencyExchange> ce = currencyExchangeService.getAllCurrencyExchange();
		for (CurrencyExchange currencyExchange : ce) {
			documentRepository.save(new Document("CurrencyExchange" + currencyExchange.getCurrencyExchangeId(),
					"CurrencyExchange" + currencyExchange.getCurrencyExchangeId(), currencyExchange.toString(),
					objectMapper.writeValueAsString(currencyExchange)));
		}

		return "CurrencyExchange saved!!!";
	}

	@GetMapping("/saveCustomerCategorySolr")
	public String CustomerCategoryDocuments() throws JsonProcessingException {
		List<CustomerCategory> cc = customerCategoryService.getAllCustomerCategory();
		for (CustomerCategory customerCategory : cc) {
			documentRepository.save(new Document("CustomerCategory" + customerCategory.getCustomerCategoryId(),
					"CustomerCategory" + customerCategory.getCustomerCategoryId(), customerCategory.toString(),
					objectMapper.writeValueAsString(customerCategory)));
		}

		return "CustomerCategory saved!!!";
	}

	@GetMapping("/saveDeliveryMethodOverridesSolr")
	public String DeliveryMethodOverridesDocuments() throws JsonProcessingException {
		List<DeliveryMethodOverrides> dmo = deliveryMethodOverridesService.getAllDeliveryMethodOverrides();
		for (DeliveryMethodOverrides deliveryMethodOverrides : dmo) {
			documentRepository.save(new Document("DeliveryMethodOverrides" + deliveryMethodOverrides.getId(),
					"DeliveryMethodOverrides" + deliveryMethodOverrides.getId(), deliveryMethodOverrides.toString(),
					objectMapper.writeValueAsString(deliveryMethodOverrides)));
		}

		return "DeliveryMethodOverrides saved!!!";
	}

	@GetMapping("/saveDeliveryMethodsSolr")
	public String DeliveryMethodsDocuments() throws JsonProcessingException {
		List<DeliveryMethods> dm = DeliveryMethodsService.getAllDeliveryMethods();
		for (DeliveryMethods deliveryMethods : dm) {
			documentRepository.save(new Document("DeliveryMethods" + deliveryMethods.getDeliveryMethodsId(),
					"DeliveryMethods" + deliveryMethods.getDeliveryMethodsId(), deliveryMethods.toString(),
					objectMapper.writeValueAsString(deliveryMethods)));
		}

		return "DeliveryMethodOverrides saved!!!";
	}

	@GetMapping("/saveDiscountCardKeyInfoSolr")
	public String DiscountCardKeyInfoDocuments() throws JsonProcessingException {
		List<DiscountCardKeyInfo> dcki = discountCardKeyInfoService.getAllDiscountCardKeyInfo();
		for (DiscountCardKeyInfo discountCardKeyInfo : dcki) {
			documentRepository.save(new Document("DiscountCardKeyInfo" + discountCardKeyInfo.getId(),
					"DiscountCardKeyInfo" + discountCardKeyInfo.getId(), discountCardKeyInfo.toString(),
					objectMapper.writeValueAsString(discountCardKeyInfo)));
		}

		return "DiscountCardKeyInfo saved!!!";
	}

	@GetMapping("/saveEffectiveDatesForDiscountSolr")
	public String EffectiveDatesForDiscountDocuments() throws JsonProcessingException {
		List<EffectiveDatesForDiscount> edfd = EffectiveDatesForDiscountService.getAllEffectiveDatesForDiscount();
		for (EffectiveDatesForDiscount effectiveDatesForDiscount : edfd) {
			documentRepository.save(new Document("EffectiveDatesForDiscount" + effectiveDatesForDiscount.getId(),
					"DiscountCardKeyInfo" + effectiveDatesForDiscount.getId(), effectiveDatesForDiscount.toString(),
					objectMapper.writeValueAsString(effectiveDatesForDiscount)));
		}

		return "EffectiveDatesForDiscount saved!!!";
	}

	@GetMapping("/saveExtractFilterSolr")
	public String ExtractFilterDocuments() throws JsonProcessingException {
		List<ExtractFilter> ef = extractFilterService.getAllExtractFilter();
		for (ExtractFilter extractFilter : ef) {
			documentRepository
					.save(new Document("ExtractFilter" + extractFilter.getId(), "ExtractFilter" + extractFilter.getId(),
							extractFilter.toString(), objectMapper.writeValueAsString(extractFilter)));
		}

		return "ExtractFilter saved!!!";
	}

	@GetMapping("/saveInsertsSolr")
	public String InsertsDocuments() throws JsonProcessingException {
		List<Inserts> i = insertService.getAllInserts();
		for (Inserts inserts : i) {
			documentRepository.save(new Document("Inserts" + inserts.getId(), "Inserts" + inserts.getId(),
					inserts.toString(), objectMapper.writeValueAsString(inserts)));
		}

		return "Inserts saved!!!";
	}

	@GetMapping("/saveInvoiceEmailsTempletSolr")
	public String InvoiceEmailsTempletDocuments() throws JsonProcessingException {
		List<InvoiceEmailsTemplet> iet = InvoiceEmailsTempletService.getAllInvoiceEmailsTemplet();
		for (InvoiceEmailsTemplet invoiceEmailsTemplet : iet) {
			documentRepository.save(new Document("InvoiceEmailsTemplet" + invoiceEmailsTemplet.getId(),
					"invoiceEmailsTemplet" + invoiceEmailsTemplet.getId(), invoiceEmailsTemplet.toString(),
					objectMapper.writeValueAsString(invoiceEmailsTemplet)));
		}

		return "invoiceEmailsTemplet saved!!!";
	}

	@GetMapping("/saveIssueGenerationSolr")
	public String IssueGenerationDocuments() throws JsonProcessingException {
		List<IssueGeneration> ig = issueGenerationService.getAllIssueGeneration();
		for (IssueGeneration issueGeneration : ig) {
			documentRepository.save(new Document("IssueGeneration" + issueGeneration.getId(),
					"IssueGeneration" + issueGeneration.getId(), issueGeneration.toString(),
					objectMapper.writeValueAsString(issueGeneration)));
		}

		return "IssueGeneration saved!!!";
	}

	@GetMapping("/saveIssueSettingsSolr")
	public String IssueSettingsDocuments() throws JsonProcessingException {
		List<IssueSettings> is = IssueSettingsService.getAllIssueSettings();
		for (IssueSettings issueSettings : is) {
			documentRepository
					.save(new Document("IssueSettings" + issueSettings.getId(), "IssueSettings" + issueSettings.getId(),
							issueSettings.toString(), objectMapper.writeValueAsString(issueSettings)));
		}

		return "IssueSettings saved!!!";
	}

	@GetMapping("/saveJobQueueSolr")
	public String JobQueueDocuments() throws JsonProcessingException {
		List<JobQueue> jq = jobQueueService.getAllJobQueue();
		for (JobQueue jobQueue : jq) {
			documentRepository.save(new Document("JobQueue" + jobQueue.getJobid(), "JobQueue" + jobQueue.getJobid(),
					jobQueue.toString(), objectMapper.writeValueAsString(jobQueue)));
		}

		return "JobQueue saved!!!";
	}

	@GetMapping("/saveJurisdictionsSolr")
	public String JurisdictionsDocuments() throws JsonProcessingException {
		List<Jurisdictions> ju = JurisdictionsService.getAllJurisdictions();
		for (Jurisdictions jurisdictions : ju) {
			documentRepository
					.save(new Document("Jurisdictions" + jurisdictions.getId(), "Jurisdictions" + jurisdictions.getId(),
							jurisdictions.toString(), objectMapper.writeValueAsString(jurisdictions)));
		}

		return "Jurisdictions saved!!!";
	}

	@GetMapping("/saveLableFormatSolr")
	public String LableFormatDocuments() throws JsonProcessingException {
		List<LableFormat> lf = LableFormatService.getAllLableFormat();
		for (LableFormat lableFormat : lf) {
			documentRepository.save(new Document("LableFormat" + lableFormat.getLableFormatId(),
					"LableFormat" + lableFormat.getLableFormatId(), lableFormat.toString(),
					objectMapper.writeValueAsString(lableFormat)));
		}

		return "LableFormat saved!!!";
	}

	@GetMapping("/saveLableFormatGroupsSolr")
	public String LableFormatGroupsDocuments() throws JsonProcessingException {
		List<LableFormatGroups> lfg = lableFormatGroupsService.getAllLableFormatGroups();
		for (LableFormatGroups lableFormatGroups : lfg) {
			documentRepository.save(new Document("LableFormatGroups" + lableFormatGroups.getLableFormatGroupId(),
					"LableFormat" + lableFormatGroups.getLableFormatGroupId(), lableFormatGroups.toString(),
					objectMapper.writeValueAsString(lableFormatGroups)));
		}

		return "LableFormatGroups saved!!!";
	}

	@GetMapping("/saveLableGroupSolr")
	public String LableGroupDocuments() throws JsonProcessingException {
		List<LableGroup> lg = LableGroupService.getAllLableGroup();
		for (LableGroup lableGroup : lg) {
			documentRepository.save(new Document("LableGroup" + lableGroup.getLableGroupId(),
					"LableFormat" + lableGroup.getLableGroupId(), lableGroup.toString(),
					objectMapper.writeValueAsString(lableGroup)));
		}

		return "LableGroup saved!!!";
	}

	@GetMapping("/saveLableKeyLineSolr")
	public String LableKeyLineDocuments() throws JsonProcessingException {
		List<LableKeyLine> lkl = lableKeyLineService.getAllLableKeyLine();
		for (LableKeyLine lableKeyLine : lkl) {
			documentRepository.save(new Document("LableKeyLine" + lableKeyLine.getLableKeylineId(),
					"LableKeyLine" + lableKeyLine.getLableKeylineId(), lableKeyLine.toString(),
					objectMapper.writeValueAsString(lableKeyLine)));
		}

		return "LableKeyLine saved!!!";
	}

	@GetMapping("/saveMakePaymentSolr")
	public String MakePaymentDocuments() throws JsonProcessingException {
		List<MakePayment> mp = MakePaymentService.getAllMakePayment();
		for (MakePayment makePayment : mp) {
			
			CustomerOrderPaymentMakePaymentInfo allInfo = new CustomerOrderPaymentMakePaymentInfo();
			
//			allInfo.setPaymentInfos(Arrays.asList(mapper.convertValue(paymentInformation, PaymentInfoSolrVO.class)));
//			allInfo.setPaymentAccounts(MakePaymentService.findAllMakePaymentForOrder(order.getOrderId()).stream().
//					map(m -> mapper.convertValue(m, MakePaymentSolrVO.class)).collect(Collectors.toList()));
//			allInfo.setOrders(Arrays.asList(mapper.convertValue(order, OrderSolrVO.class)));
//			allInfo.setCustomer(Arrays.asList(mapper.convertValue(order.getCustomerId(), CustomerSolrVO.class)));
			
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			Order order = makePayment.getOrder();
			allInfo.setPaymentAccounts(Arrays.asList(mapper.convertValue(makePayment, MakePaymentSolrVO.class)));
			allInfo.setOrders(Arrays.asList(mapper.convertValue(order, OrderSolrVO.class)));
			allInfo.setCustomer(Arrays.asList(mapper.convertValue(order.getCustomerId(), CustomerSolrVO.class)));
			allInfo.setPaymentInfos(paymentInformationService.getPaymentInformationByOrderId(order.getOrderId(), PageRequest.of(0, Integer.MAX_VALUE))
					.stream().map(p -> mapper.convertValue(p, PaymentInfoSolrVO.class)).collect(Collectors.toList()));
			
			documentRepository.save(new Document("MakePayment" + makePayment.getId(), "MakePayment" + makePayment.getId(),
					allInfo.toString(), objectMapper.writeValueAsString(allInfo)));
		}

		return "MakePayment saved!!!";
	}

	@GetMapping("/saveNthSolr")
	public String NthDocuments() throws JsonProcessingException {
		List<Nth> nth = NthService.getAllNth();
		for (Nth nth1 : nth) {
			documentRepository.save(new Document("Nth" + nth1.getNthid(), "MakePayment" + nth1.getNthid(),
					nth1.toString(), objectMapper.writeValueAsString(nth1)));
		}

		return "Nth saved!!!";
	}

	

	@GetMapping("/saveOrderAddressMappingSolr")
	public String OrderAddressMappingDocuments() throws JsonProcessingException {
		List<OrderAddressMapping> oam = AddOrderService.getAllOrderAddressMapping();
		for (OrderAddressMapping orderAddressMapping : oam) {
			documentRepository2.save(new Document2("OrderAddressMapping" + orderAddressMapping.getId(),
					"OrderAddressMapping" + orderAddressMapping.getId(), orderAddressMapping.toString(),
					objectMapper.writeValueAsString(orderAddressMapping)));
		}

		return "OrderAddressMapping saved!!!";
	}

	@GetMapping("/saveOrderAuxiliaryInformationSolr")
	public String OrderAuxiliaryInformationDocuments() throws JsonProcessingException {
		List<OrderAuxiliaryInformation> oai = AddOrderService.getAllOrderAuxiliaryInformation();
		for (OrderAuxiliaryInformation orderAuxiliaryInformation : oai) {
			documentRepository.save(new Document("OrderAuxiliaryInformation" + orderAuxiliaryInformation.getId(),
					"OrderAuxiliaryInformation" + orderAuxiliaryInformation.getId(),
					orderAuxiliaryInformation.toString(), objectMapper.writeValueAsString(orderAuxiliaryInformation)));
		}

		return "OrderAuxiliaryInformation saved!!!";
	}

	@GetMapping("/saveOrderCategorySolr")
	public String OrderCategoryDocuments() throws JsonProcessingException {
		List<OrderCategory> oc = AddOrderService.getAllOrderCategory();
		for (OrderCategory orderCategory : oc) {
			documentRepository.save(new Document("OrderCategory" + orderCategory.getOrderCategoryId(),
					"OrderCategory" + orderCategory.getOrderCategoryId(), orderCategory.toString(),
					objectMapper.writeValueAsString(orderCategory)));
		}

		return "OrderCategory saved!!!";
	}

	@GetMapping("/saveOrderClassSolr")
	public String OrderClassDocuments() throws JsonProcessingException {
		List<OrderClass> oclass = OrderClassService.getAllOrderClass();
		for (OrderClass orderClass : oclass) {
			documentRepository
					.save(new Document("OrderClass" + orderClass.getOcId(), "OrderClass" + orderClass.getOcId(),
							orderClass.toString(), objectMapper.writeValueAsString(orderClass)));
		}

		return "OrderClass saved!!!";
	}

	@GetMapping("/saveOrderClassOverviewSolr")
	public String OrderClassOverviewDocuments() throws JsonProcessingException {
		List<OrderClassOverview> oco = OrderClassOverviewService.getAllOrderClassOverview();
		for (OrderClassOverview orderClassOverview : oco) {
			documentRepository.save(new Document("OrderClassOverview" + orderClassOverview.getId(),
					"OrderClassOverview" + orderClassOverview.getId(), orderClassOverview.toString(),
					objectMapper.writeValueAsString(orderClassOverview)));
		}

		return "OrderClassOverview saved!!!";
	}

	@GetMapping("/saveOrderCodesSolr")
	public String OrderCodesDocuments() throws JsonProcessingException {
		List<OrderCodes> ocodes = orderCodesService.getAllOrderCodes();
		for (OrderCodes orderCodes : ocodes) {
			documentRepository.save(new Document("OrderCodes" + orderCodes.getId(), "OrderCodes" + orderCodes.getId(),
					orderCodes.toString(), objectMapper.writeValueAsString(orderCodes)));
		}

		return "OrderCodes saved!!!";
	}

	@GetMapping("/saveOrderCodesSuperSolr")
	public String OrderCodesSuperDocuments() throws JsonProcessingException {
		List<OrderCodesSuper> ocs = orderCodesService.getAllOrderCodesSuper();
		for (OrderCodesSuper orderCodesSuper : ocs) {
			documentRepository.save(new Document("OrderCodesSuper" + orderCodesSuper.getId(),
					"OrderCodesSuper" + orderCodesSuper.getId(), orderCodesSuper.toString(),
					objectMapper.writeValueAsString(orderCodesSuper)));
		}

		return "OrderCodesSuper saved!!!";
	}

	@GetMapping("/saveOrderDeliveryOptionsSolr")
	public String OrderDeliveryOptionsDocuments() throws JsonProcessingException {
		List<OrderDeliveryOptions> odo = AddOrderService.getAllOrderDeliveryOptions();
		for (OrderDeliveryOptions orderDeliveryOptions : odo) {
			documentRepository.save(new Document("OrderDeliveryOptions" + orderDeliveryOptions.getId(),
					"OrderDeliveryOptions" + orderDeliveryOptions.getId(), orderDeliveryOptions.toString(),
					objectMapper.writeValueAsString(orderDeliveryOptions)));
		}

		return "OrderDeliveryOptions saved!!!";
	}

	@GetMapping("/saveOrderItemDetailsSolr")
	public String OrderItemDetailsDocuments() throws JsonProcessingException {
		List<OrderItemDetails> oid = orderCodesService.getAllOrderItemDetails();
		for (OrderItemDetails orderItemDetails : oid) {
			documentRepository.save(new Document("OrderItemDetails" + orderItemDetails.getId(),
					"OrderItemDetails" + orderItemDetails.getId(), orderItemDetails.toString(),
					objectMapper.writeValueAsString(orderItemDetails)));
		}

		return "OrderItemDetails saved!!!";
	}

	@GetMapping("/saveOrderItemsSolr")
	public String OrderItemsDocuments() throws JsonProcessingException {
		List<OrderItems> oi = AddOrderService.getAllOrderItems();
		for (OrderItems orderItems : oi) {
			documentRepository.save(new Document("OrderItems" + orderItems.getId(), "OrderItems" + orderItems.getId(),
					orderItems.toString(), objectMapper.writeValueAsString(orderItems)));
		}

		return "OrderItems saved!!!";
	}

	@GetMapping("/saveOrderKeyInformationSolr")
	public String OrderKeyInformationDocuments() throws JsonProcessingException {
		List<OrderKeyInformation> oki = AddOrderService.getAllOrderKeyInformation();
		for (OrderKeyInformation orderKeyInformation : oki) {
			documentRepository.save(new Document("OrderKeyInformation" + orderKeyInformation.getId(),
					"OrderKeyInformation" + orderKeyInformation.getId(), orderKeyInformation.toString(),
					objectMapper.writeValueAsString(orderKeyInformation)));
		}

		return "OrderKeyInformation saved!!!";
	}

	@GetMapping("/saveOrderPackageOptionsSolr")
	public String OrderPackageOptionsDocuments() throws JsonProcessingException {
		List<OrderPackageOptions> opo = orderCodesService.getAllOrderOptions();
		for (OrderPackageOptions orderPackageOptions : opo) {
			documentRepository.save(new Document("OrderPackageOptions" + orderPackageOptions.getId(),
					"OrderPackageOptions" + orderPackageOptions.getId(), orderPackageOptions.toString(),
					objectMapper.writeValueAsString(orderPackageOptions)));
		}

		return "OrderPackageOptions saved!!!";
	}

	@GetMapping("/saveOrderPaymentOptionsSolr")
	public String OrderPaymentOptionsDocuments() throws JsonProcessingException {
		List<OrderPaymentOptions> opayOp = orderCodesService.getAllOrderPaymentOptions();
		for (OrderPaymentOptions orderPaymentOptions : opayOp) {
			documentRepository.save(new Document("OrderPaymentOptions" + orderPaymentOptions.getId(),
					"OrderPaymentOptions" + orderPaymentOptions.getId(), orderPaymentOptions.toString(),
					objectMapper.writeValueAsString(orderPaymentOptions)));
		}

		return "orderPaymentOptions saved!!!";
	}

//	@GetMapping("/saveOrdersToBeSuspendedSolr")
//	public String OrdersToBeSuspendedDocuments() {
//		List<OrdersToBeSuspended> otbs = SuspendOrderService.getAllOrdersToBeSuspended();	
//	for (OrdersToBeSuspended ordersToBeSuspended : otbs) {
//		documentRepository.save(new Document("OrdersToBeSuspended" + ordersToBeSuspended.getId(),
//				"OrdersToBeSuspended" + ordersToBeSuspended.getId(), ordersToBeSuspended.toString(), objectMapper.writeValueAsString(ordersToBeSuspended)));
//	}
//
//	return "OrdersToBeSuspended saved!!!";
//	}

	@GetMapping("/saveOrderThresholdInfoSolr")
	public String OrderThresholdInfoDocuments() throws JsonProcessingException {
		List<OrderThresholdInfo> oti = orderThresholdInfoService.getAllOrderThresholdInfo();
		for (OrderThresholdInfo orderThresholdInfo : oti) {
			documentRepository.save(new Document("OrdersToBeSuspended" + orderThresholdInfo.getId(),
					"OrdersToBeSuspended" + orderThresholdInfo.getId(), orderThresholdInfo.toString(),
					objectMapper.writeValueAsString(orderThresholdInfo)));
		}

		return "OrderThresholdInfo saved!!!";
	}

	@GetMapping("/saveOutputSortSolr")
	public String OutputSortDocuments() throws JsonProcessingException {
		List<OutputSort> os = outputSortService.getAllOutputSort();
		for (OutputSort outputSort : os) {
			documentRepository.save(new Document("OutputSort" + outputSort.getId(), "OutputSort" + outputSort.getId(),
					outputSort.toString(), objectMapper.writeValueAsString(outputSort)));
		}

		return "OutputSort saved!!!";
	}

	@GetMapping("/saveOutputValueSolr")
	public String OutputValueDocuments() throws JsonProcessingException {
		List<OutputValue> ov = outputValueService.getAllOutputValue();
		for (OutputValue outputValue : ov) {
			documentRepository
					.save(new Document("OutputValue" + outputValue.getId(), "OutputValue" + outputValue.getId(),
							outputValue.toString(), objectMapper.writeValueAsString(outputValue)));
		}

		return "OutputValue saved!!!";
	}

	@GetMapping("/saveParentChildMappingSolr")
	public String ParentChildMappingDocuments() throws JsonProcessingException {
		List<ParentChildMapping> pcmp = parentChildMappingService.getAllParentChildMapping();
		for (ParentChildMapping parentChildMapping : pcmp) {
			documentRepository.save(new Document("ParentChildMapping" + parentChildMapping.getId(),
					"ParentChildMapping" + parentChildMapping.getId(), parentChildMapping.toString(),
					objectMapper.writeValueAsString(parentChildMapping)));
		}

		return "ParentChildMapping saved!!!";
	}

	@GetMapping("/savePaymentBreakdownSolr")
	public String PaymentBreakdownDocuments() throws JsonProcessingException {
		List<PaymentBreakdown> pbwn = AddOrderService.getAllPaymentBreakdown();
		for (PaymentBreakdown paymentBreakdown : pbwn) {
			documentRepository.save(new Document("PaymentBreakdown" + paymentBreakdown.getId(),
					"PaymentBreakdown" + paymentBreakdown.getId(), paymentBreakdown.toString(),
					objectMapper.writeValueAsString(paymentBreakdown)));
		}

		return "PaymentBreakdown saved!!!";
	}


	@GetMapping("/savePaymentLinkStatusSolr")
	public String PaymentLinkStatusDocuments() throws JsonProcessingException {
		List<PaymentLinkStatus> pls = paymentLinkStatusService.getAllPaymentLinkStatus();
		for (PaymentLinkStatus paymentLinkStatus : pls) {
			documentRepository.save(new Document("PaymentLinkStatus" + paymentLinkStatus.getId(),
					"PaymentLinkStatus" + paymentLinkStatus.getId(), paymentLinkStatus.toString(),
					objectMapper.writeValueAsString(paymentLinkStatus)));
		}

		return "PaymentLinkStatus saved!!!";
	}

	@GetMapping("/savePaymentThresholdSolr")
	public String PaymentThresholdDocuments() throws JsonProcessingException {
		List<PaymentThreshold> pthsld = paymentThresholdService.getAllPaymentThreshold();
		for (PaymentThreshold paymentThreshold : pthsld) {
			documentRepository.save(new Document("PaymentThreshold" + paymentThreshold.getPaymentThresholdId(),
					"PaymentThreshold" + paymentThreshold.getPaymentThresholdId(), paymentThreshold.toString(),
					objectMapper.writeValueAsString(paymentThreshold)));
		}

		return "PaymentThreshold saved!!!";
	}

	@GetMapping("/savePaymentTypeSolr")
	public String PaymentTypeDocuments() throws JsonProcessingException {
		List<PaymentType> ptype = paymentTypeService.getAllPaymentType();
		for (PaymentType paymentType : ptype) {
			documentRepository
					.save(new Document("PaymentType" + paymentType.getId(), "PaymentType" + paymentType.getId(),
							paymentType.toString(), objectMapper.writeValueAsString(paymentType)));
		}

		return "PaymentType saved!!!";
	}

	@GetMapping("/saveProcessOutputSolr")
	public String ProcessOutputDocuments() throws JsonProcessingException {
		List<ProcessOutput> po = processOutputService.getAllProcessOutput();
		for (ProcessOutput processOutput : po) {
			documentRepository.save(new Document("ProcessOutput" + processOutput.getOutput_id(),
					"ProcessOutput" + processOutput.getOutput_id(), processOutput.toString(),
					objectMapper.writeValueAsString(processOutput)));
		}

		return "ProcessOutput saved!!!";
	}

	@GetMapping("/saveProcessTypeSolr")
	public String ProcessTypeDocuments() throws JsonProcessingException {
		List<ProcessType> ptype = ProcessTypeService.getAllProcessType();
		for (ProcessType processType : ptype) {
			documentRepository
					.save(new Document("ProcessType" + processType.getPid(), "ProcessType" + processType.getPid(),
							processType.toString(), objectMapper.writeValueAsString(processType)));
		}

		return "ProcessType saved!!!";
	}

	@GetMapping("/saveProfitCenterSolr")
	public String ProfitCenterDocuments() throws JsonProcessingException {
		List<ProfitCenter> pcenter = profitCenterService.getAllProfitCenter();
		for (ProfitCenter profitCenter : pcenter) {
			documentRepository.save(
					new Document("ProfitCenter" + profitCenter.getProftId(), "ProfitCenter" + profitCenter.getProftId(),
							profitCenter.toString(), objectMapper.writeValueAsString(profitCenter)));
		}

		return "ProfitCenter saved!!!";
	}

	@GetMapping("/savePublisherSolr")
	public String PublisherDocuments() throws JsonProcessingException {
		List<Publisher> pub = publisherSerivce.getAllPublisher();
		for (Publisher publisher : pub) {
			documentRepository.save(new Document("Publisher" + publisher.getId(), "Publisher" + publisher.getId(),
					publisher.toString(), objectMapper.writeValueAsString(publisher)));
		}

		return "Publisher saved!!!";
	}

	@GetMapping("/saveQueueSolr")
	public String QueueDocuments() throws JsonProcessingException {
		List<Queue> queue = QueueService.getAllQueue();
		for (Queue queue1 : queue) {
			documentRepository.save(new Document("Queue" + queue1.getId(), "Queue" + queue1.getId(), queue1.toString(),
					objectMapper.writeValueAsString(queue1)));
		}

		return "Queue saved!!!";
	}

	@GetMapping("/saveRateCardsSolr")
	public String RateCardsDocuments() throws JsonProcessingException {
		List<RateCards> rcard = rateCardsService.getAllRateCards();
		for (RateCards rateCards : rcard) {
			documentRepository.save(new Document("RateCards" + rateCards.getRcId(), "RateCards" + rateCards.getRcId(),
					rateCards.toString(), objectMapper.writeValueAsString(rateCards)));
		}

		return "RateCards saved!!!";
	}

	@GetMapping("/saveRateCardsRenewalsSolr")
	public String RateCardsRenewalsDocuments() throws JsonProcessingException {
		List<RateCardsRenewals> rcr = rateCardsRenewalsService.getAllRateCardsRenewals();
		for (RateCardsRenewals rateCardsRenewals : rcr) {
			documentRepository.save(new Document("RateCardsRenewals" + rateCardsRenewals.getId(),
					"RateCardsRenewals" + rateCardsRenewals.getId(), rateCardsRenewals.toString(),
					objectMapper.writeValueAsString(rateCardsRenewals)));
		}

		return "RateCardsRenewals saved!!!";
	}

	@GetMapping("/saveRCEffortRangeSolr")
	public String RCEffortRangeDocuments() throws JsonProcessingException {
		List<RCEffortRange> rcer = rCEffortRangeService.getAllRCEffortRange();
		for (RCEffortRange rCEffortRange : rcer) {
			documentRepository
					.save(new Document("RCEffortRange" + rCEffortRange.getId(), "RCEffortRange" + rCEffortRange.getId(),
							rCEffortRange.toString(), objectMapper.writeValueAsString(rCEffortRange)));
		}

		return "RCEffortRange saved!!!";
	}

	@GetMapping("/saveRenewalCardSolr")
	public String RenewalCardDocuments() throws JsonProcessingException {
		List<RenewalCard> rc = renewalCardService.getAllRenewalCard();
		for (RenewalCard renewalCard : rc) {
			documentRepository.save(new Document("RenewalCard" + renewalCard.getRenewalCardId(),
					"RenewalCard" + renewalCard.getRenewalCardId(), renewalCard.toString(),
					objectMapper.writeValueAsString(renewalCard)));
		}

		return "RenewalCard saved!!!";
	}

	@GetMapping("/saveRenewalDefinitionSolr")
	public String RenewalDefinitionDocuments() throws JsonProcessingException {
		List<RenewalDefinition> rd = renewalDefinitionService.getAllRenewalDefinition();
		for (RenewalDefinition renewalDefinition : rd) {
			documentRepository.save(new Document("RenewalDefinition" + renewalDefinition.getId(),
					"RenewalDefinition" + renewalDefinition.getId(), renewalDefinition.toString(),
					objectMapper.writeValueAsString(renewalDefinition)));
		}

		return "RenewalDefinition saved!!!";
	}

	@GetMapping("/saveRenewalOfferDetailsSolr")
	public String RenewalOfferDetailsDocuments() throws JsonProcessingException {
		List<RenewalOfferDetails> rod = renewalOfferDetailsService.getAllRenewalOfferDetails();
		for (RenewalOfferDetails renewalOfferDetails : rod) {
			documentRepository.save(new Document("RenewalOfferDetails" + renewalOfferDetails.getRenewalOfferDetailsId(),
					"RenewalOfferDetails" + renewalOfferDetails.getRenewalOfferDetailsId(),
					renewalOfferDetails.toString(), objectMapper.writeValueAsString(renewalOfferDetails)));
		}

		return "RenewalOfferDetails saved!!!";
	}

	@GetMapping("/saveRentalStatusSolr")
	public String RentalStatusDocuments() throws JsonProcessingException {
		List<RentalStatus> rs = rentalStatusService.getAllRentalStatus();
		for (RentalStatus rentalStatus : rs) {
			documentRepository.save(new Document("RentalStatus" + rentalStatus.getRentalStatusId(),
					"RentalStatus" + rentalStatus.getRentalStatusId(), rentalStatus.toString(),
					objectMapper.writeValueAsString(rentalStatus)));
		}

		return "RentalStatus saved!!!";
	}

	@GetMapping("/saveRepeatingSolr")
	public String RepeatingDocuments() throws JsonProcessingException {
		List<Repeating> r = repeatingService.getAllRepeating();
		for (Repeating repeating : r) {
			documentRepository.save(new Document("Repeating" + repeating.getId(), "Repeating" + repeating.getId(),
					repeating.toString(), objectMapper.writeValueAsString(repeating)));
		}

		return "Repeating saved!!!";
	}

	@GetMapping("/saveSalesRepresentativeSolr")
	public String SalesRepresentativeDocuments() throws JsonProcessingException {
		List<SalesRepresentative> sr = salesRepresentativeService.getAllSalesRepresentative();
		for (SalesRepresentative salesRepresentative : sr) {
			documentRepository.save(new Document("SalesRepresentative" + salesRepresentative.getSalesRepID(),
					"SalesRepresentative" + salesRepresentative.getSalesRepID(), salesRepresentative.toString(),
					objectMapper.writeValueAsString(salesRepresentative)));
		}

		return "SalesRepresentative saved!!!";
	}

	@GetMapping("/saveShippingMethodSolr")
	public String ShippingMethodDocuments() throws JsonProcessingException {
		List<ShippingMethod> sm = shippingMethodService.getAllShippingMethod();
		for (ShippingMethod shippingMethod : sm) {
			documentRepository.save(
					new Document("ShippingMethod" + shippingMethod.getId(), "ShippingMethod" + shippingMethod.getId(),
							shippingMethod.toString(), objectMapper.writeValueAsString(shippingMethod)));
		}

		return "ShippingMethod saved!!!";
	}

	@GetMapping("/saveShippingPriceListSolr")
	public String ShippingPriceListDocuments() throws JsonProcessingException {
		List<ShippingPriceList> spl = shippingPriceListService.getAllShippingPriceList();
		for (ShippingPriceList shippingPriceList : spl) {
			documentRepository.save(new Document("ShippingPriceList" + shippingPriceList.getId(),
					"ShippingPriceList" + shippingPriceList.getId(), shippingPriceList.toString(),
					objectMapper.writeValueAsString(shippingPriceList)));
		}

		return "ShippingPriceList saved!!!";
	}

	@GetMapping("/saveSourceAttributesSolr")
	public String SourceAttributesDocuments() throws JsonProcessingException {
		List<SourceAttributes> sa = sourceAttributesService.getAllSourceAttributes();
		for (SourceAttributes sourceAttributes : sa) {
			documentRepository.save(new Document("SourceAttributes" + sourceAttributes.getId(),
					"SourceAttributes" + sourceAttributes.getId(), sourceAttributes.toString(),
					objectMapper.writeValueAsString(sourceAttributes)));
		}

		return "SourceAttributes saved!!!";
	}

	@GetMapping("/saveSourceAttributeValuesSolr")
	public String SourceAttributeValuesDocuments() throws JsonProcessingException {
		List<SourceAttributeValues> sa = sourceAttributeValuesService.getAllSourceAttributes();
		for (SourceAttributeValues sourceAttributeValues : sa) {
			documentRepository.save(new Document("SourceAttributeValues" + sourceAttributeValues.getId(),
					"SourceAttributeValues" + sourceAttributeValues.getId(), sourceAttributeValues.toString(),
					objectMapper.writeValueAsString(sourceAttributeValues)));
		}

		return "SourceAttributeValues saved!!!";
	}

	@GetMapping("/saveSourceCodeSolr")
	public String SourceCodeDocuments() throws JsonProcessingException {
		List<SourceCode> sc = sourceCodeService.getAllSourceCode();
		for (SourceCode sourceCode : sc) {
			documentRepository.save(new Document("SourceCode" + sourceCode.getSourceCodeId(),
					"SourceCode" + sourceCode.getSourceCodeId(), sourceCode.toString(),
					objectMapper.writeValueAsString(sourceCode)));
		}

		return "SourceCode saved!!!";
	}

	@GetMapping("/saveSourceCodeAndValuesMappingSolr")
	public String SourceCodeAndValuesMappingDocuments() throws JsonProcessingException {
		List<SourceCodeAndValuesMapping> scvm = sourceCodeService.getAllSourceCodeAndValuesMapping();
		for (SourceCodeAndValuesMapping sourceCodeAndValuesMapping : scvm) {
			documentRepository.save(new Document("SourceCodeAndValuesMapping" + sourceCodeAndValuesMapping.getId(),
					"SourceCodeAndValuesMapping" + sourceCodeAndValuesMapping.getId(),
					sourceCodeAndValuesMapping.toString(),
					objectMapper.writeValueAsString(sourceCodeAndValuesMapping)));
		}

		return "SourceCodeAndValuesMapping saved!!!";
	}

	@GetMapping("/saveSourceFormatSolr")
	public String SourceFormatDocuments() throws JsonProcessingException {
		List<SourceFormat> sf = sourceFormatService.getAllSourceFormat();
		for (SourceFormat sourceFormat : sf) {
			documentRepository
					.save(new Document("SourceFormat" + sourceFormat.getId(), "SourceFormat" + sourceFormat.getId(),
							sourceFormat.toString(), objectMapper.writeValueAsString(sourceFormat)));
		}

		return "SourceFormat saved!!!";
	}

	@GetMapping("/saveSourceFormatAndAttributeMappingSolr")
	public String SourceFormatAndAttributeMappingDocuments() throws JsonProcessingException {
		List<SourceFormatAndAttributeMapping> sfam = sourceFormatService.getAllSourceFormatAndAttributeMapping();
		for (SourceFormatAndAttributeMapping sourceFormatAndAttributeMapping : sfam) {
			documentRepository
					.save(new Document("SourceFormatAndAttributeMapping" + sourceFormatAndAttributeMapping.getId(),
							"SourceFormatAndAttributeMapping" + sourceFormatAndAttributeMapping.getId(),
							sourceFormatAndAttributeMapping.toString(),
							objectMapper.writeValueAsString(sourceFormatAndAttributeMapping)));
		}

		return "SourceFormatAndAttributeMapping saved!!!";
	}

	@GetMapping("/saveSourceFormatSegmentSolr")
	public String SourceFormatSegmentDocuments() throws JsonProcessingException {
		List<SourceFormatSegment> sfs = sourceFormatSegmentService.getAllSourceFormatSegment();
		for (SourceFormatSegment sourceFormatSegment : sfs) {
			documentRepository.save(new Document("SourceFormatSegment" + sourceFormatSegment.getId(),
					"SourceFormatSegment" + sourceFormatSegment.getId(), sourceFormatSegment.toString(),
					objectMapper.writeValueAsString(sourceFormatSegment)));
		}

		return "SourceFormatSegment saved!!!";
	}

	@GetMapping("/saveSpecialTaxIdsSolr")
	public String SpecialTaxIdsDocuments() throws JsonProcessingException {
		List<SpecialTaxIds> spclTax = specialTaxIdsService.getAllSpecialTaxIds();
		for (SpecialTaxIds specialTaxIds : spclTax) {
			documentRepository
					.save(new Document("SpecialTaxIds" + specialTaxIds.getId(), "SpecialTaxIds" + specialTaxIds.getId(),
							specialTaxIds.toString(), objectMapper.writeValueAsString(specialTaxIds)));
		}

		return "SpecialTaxIds saved!!!";
	}

	@GetMapping("/saveSplitsSolr")
	public String SplitsDocuments() throws JsonProcessingException {
		List<Splits> splt = splitsService.getAllSplits();
		for (Splits splits : splt) {
			documentRepository.save(new Document("Splits" + splits.getId(), "Splits" + splits.getId(),
					splits.toString(), objectMapper.writeValueAsString(splits)));
		}

		return "Splits saved!!!";
	}

	@GetMapping("/saveSubmitJobSolr")
	public String SubmitJobDocuments() throws JsonProcessingException {
		List<SubmitJob> sj = submitJobService.getAllSubmitJob();
		for (SubmitJob submitJob : sj) {
			documentRepository.save(new Document("SubmitJob" + submitJob.getId(), "SubmitJob" + submitJob.getId(),
					submitJob.toString(), objectMapper.writeValueAsString(submitJob)));
		}

		return "SubmitJob saved!!!";
	}

	@GetMapping("/saveSubscriptionCategorySolr")
	public String SubscriptionCategoryDocuments() throws JsonProcessingException {
		List<SubscriptionCategory> subscatgry = subscriptionCategoryService.getAllSubscriptionCategory();
		for (SubscriptionCategory subscriptionCategory : subscatgry) {
			documentRepository.save(new Document("SubscriptionCategory" + subscriptionCategory.getId(),
					"SubscriptionCategory" + subscriptionCategory.getId(), subscriptionCategory.toString(),
					objectMapper.writeValueAsString(subscriptionCategory)));
		}

		return "SubscriptionCategory saved!!!";
	}

	@GetMapping("/saveSubscriptionDefKeyInfoSolr")
	public String SubscriptionDefKeyInfoDocuments() throws JsonProcessingException {
		List<SubscriptionDefKeyInfo> sdki = subscriptionDefKeyInfoService.getAllSubscriptionDefKeyInfo();
		for (SubscriptionDefKeyInfo subscriptionDefKeyInfo : sdki) {
			documentRepository.save(new Document("SubscriptionCategory" + subscriptionDefKeyInfo.getId(),
					"SubscriptionCategory" + subscriptionDefKeyInfo.getId(), subscriptionDefKeyInfo.toString(),
					objectMapper.writeValueAsString(subscriptionDefKeyInfo)));
		}

		return "SubscriptionDefKeyInfo saved!!!";
	}

//	@GetMapping("/saveSuspendOrderSolr")
//	public String SuspendOrderDocuments() {
//		List<SuspendOrder> sdki = suspendOrderService.getAllSuspendOrder();	
//	for (SuspendOrder suspendOrder : sdki) {
//		documentRepository.save(new Document("SuspendOrder" + suspendOrder.getId(),
//				"SuspendOrder" + suspendOrder.getId(), suspendOrder.toString()));
//	}
//	
//	return "SuspendOrder saved!!!";
//	}

	@GetMapping("/saveTaxonomySolr")
	public String TaxonomyDocuments() throws JsonProcessingException {
		List<Taxonomy> tnomy = taxonomyService.getAllTaxonomy();
		for (Taxonomy taxonomy : tnomy) {
			documentRepository.save(new Document("Taxonomy" + taxonomy.getId(), "Taxonomy" + taxonomy.getId(),
					taxonomy.toString(), objectMapper.writeValueAsString(taxonomy)));
		}

		return "Taxonomy saved!!!";
	}

	@GetMapping("/saveTaxRateCategorySolr")
	public String TaxRateCategoryDocuments() throws JsonProcessingException {
		List<TaxRateCategory> trc = taxRateCategoryService.getAllTaxRateCategory();
		for (TaxRateCategory taxRateCategory : trc) {
			documentRepository.save(new Document("TaxRateCategory" + taxRateCategory.getId(),
					"TaxRateCategory" + taxRateCategory.getId(), taxRateCategory.toString(),
					objectMapper.writeValueAsString(taxRateCategory)));
		}

		return "TaxRateCategory saved!!!";
	}

	@GetMapping("/saveTaxTypeSolr")
	public String TaxTypeDocuments() throws JsonProcessingException {
		List<TaxType> tt = taxService.getAllTaxType();
		for (TaxType taxType : tt) {
			documentRepository.save(new Document("TaxType" + taxType.getTaxId(), "TaxType" + taxType.getTaxId(),
					taxType.toString(), objectMapper.writeValueAsString(taxType)));
		}

		return "TaxType saved!!!";
	}

	@GetMapping("/saveTermsSolr")
	public String TermsDocuments() throws JsonProcessingException {
		List<Terms> t = termsService.getAllTerms();
		for (Terms terms : t) {
			documentRepository.save(new Document("Terms" + terms.getTermsId(), "Terms" + terms.getTermsId(),
					terms.toString(), objectMapper.writeValueAsString(terms)));
		}

		return "Terms saved!!!";
	}

	@GetMapping("/saveTransportModeSolr")
	public String TransportModeDocuments() throws JsonProcessingException {
		List<TransportMode> tm = transportModeService.getAllTransportMode();
		for (TransportMode transportMode : tm) {
			documentRepository
					.save(new Document("TransportMode" + transportMode.getId(), "TransportMode" + transportMode.getId(),
							transportMode.toString(), objectMapper.writeValueAsString(transportMode)));
		}

		return "TransportMode saved!!!";
	}

	@GetMapping("/saveUnitBasedSubscriptionSolr")
	public String UnitBasedSubscriptionDocuments() throws JsonProcessingException {
		List<UnitBasedSubscription> ubs = unitBasedSubscriptionService.getAllUnitBasedSubscription();
		for (UnitBasedSubscription unitBasedSubscription : ubs) {
			documentRepository.save(new Document("UnitBasedSubscription" + unitBasedSubscription.getUbsid(),
					"UnitBasedSubscription" + unitBasedSubscription.getUbsid(), unitBasedSubscription.toString(),
					objectMapper.writeValueAsString(unitBasedSubscription)));
		}

		return "UnitBasedSubscription saved!!!";
	}

	@GetMapping("/saveValueForScAttributeSolr")
	public String ValueForScAttributeDocuments() throws JsonProcessingException {
		List<ValueForScAttribute> vfsa = valueForScAttributeService.getAllValueForScAttribute();
		for (ValueForScAttribute valueForScAttribute : vfsa) {
			documentRepository.save(new Document("ValueForScAttribute" + valueForScAttribute.getId(),
					"ValueForScAttribute" + valueForScAttribute.getId(), valueForScAttribute.toString(),
					objectMapper.writeValueAsString(valueForScAttribute)));
		}

		return "ValueForScAttribute saved!!!";
	}

	@GetMapping("/saveVolumeGroupSolr")
	public String VolumeGroupDocuments() throws JsonProcessingException {
		List<VolumeGroup> vfsa = VolumeGroupService.getAllVolumeGroup();
		for (VolumeGroup volumeGroup : vfsa) {
			documentRepository.save(new Document("VolumeGroup" + volumeGroup.getVolumeGroupId(),
					"VolumeGroup" + volumeGroup.getVolumeGroupId(), volumeGroup.toString(),
					objectMapper.writeValueAsString(volumeGroup)));
		}

		return "VolumeGroup saved!!!";
	}

	@GetMapping("/saveMultiLineItemOrderSolr")
	public String MultiLineItemOrderDocuments() throws JsonProcessingException {
		List<MultiLineItemOrder> mlio = AddOrderService.getAllMultiLineItemOrder();
		for (MultiLineItemOrder multiLineItemOrder : mlio) {
			documentRepository.save(new Document("MultiLineItemOrder" + multiLineItemOrder.getId(),
					"MultiLineItemOrder" + multiLineItemOrder.getId(), multiLineItemOrder.toString(),
					objectMapper.writeValueAsString(multiLineItemOrder)));
		}

		return "MultiLineItemOrder saved!!!";
	}

	@GetMapping("/saveAddprocessmappingSolr")
	public String AddprocessmappingDocuments() throws JsonProcessingException {
		List<Addprocessmapping> apm = addProcessService.getAllAddprocessmapping();
		for (Addprocessmapping addprocessmapping : apm) {
			documentRepository.save(new Document("Addprocessmapping" + addprocessmapping.getPmid(),
					"Addprocessmapping" + addprocessmapping.getPmid(), addprocessmapping.toString(),
					objectMapper.writeValueAsString(addprocessmapping)));
		}

		return "Addprocessmapping saved!!!";
	}

	@GetMapping("/saveAddressSolr")
	public String AddressDocuments() throws JsonProcessingException {
		List<Address> adds = addressessService.getAllAddress();
		for (Address address : adds) {
			documentRepository.save(new Document("Address" + address.getId(), "Address" + address.getId(),
					address.toString(), objectMapper.writeValueAsString(address)));
		}

		return "address saved!!!";
	}

	@GetMapping("/saveCountriesSolr")
	public String CountriesDocuments() throws JsonProcessingException {
		List<Countries> ctrys = countriesService.getAllCountries();
		for (Countries countries : ctrys) {
			documentRepository.save(new Document("Countries" + countries.getId(), "Countries" + countries.getId(),
					countries.toString(), objectMapper.writeValueAsString(countries)));
		}

		return "Countries saved!!!";
	}

	@GetMapping("/saveAddressStatusSolr")
	public String AddressStatusDocuments() throws JsonProcessingException {
		List<AddressStatus> ast = addressStatusService.getAllAddressStatus();
		for (AddressStatus addressStatus : ast) {
			documentRepository
					.save(new Document("AddressStatus" + addressStatus.getId(), "AddressStatus" + addressStatus.getId(),
							addressStatus.toString(), objectMapper.writeValueAsString(addressStatus)));
		}

		return "AddressStatus saved!!!";
	}

	@GetMapping("/saveInventoryMapperSolr")
	public String InventoryMapperDocuments() throws JsonProcessingException {
		List<InventoryMapper> invm = inventoryService.getAllInventoryMapper();
		for (InventoryMapper inventoryMapper : invm) {
			documentRepository.save(new Document("InventoryMapper" + inventoryMapper.getInventoryId(),
					"InventoryMapper" + inventoryMapper.getInventoryId(), inventoryMapper.toString(),
					objectMapper.writeValueAsString(inventoryMapper)));
		}

		return "InventoryMapper saved!!!";
	}
}