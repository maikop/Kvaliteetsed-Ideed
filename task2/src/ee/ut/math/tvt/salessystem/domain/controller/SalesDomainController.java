package ee.ut.math.tvt.salessystem.domain.controller;

import ee.ut.math.tvt.salessystem.domain.data.Client;
import ee.ut.math.tvt.salessystem.domain.data.Sale;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.SalesSystemException;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import java.util.List;

/**
 * Sales domain controller is responsible for the domain specific business
 * processes.
 */
public interface SalesDomainController {

	/**
	 * Load the current state of the warehouse.
	 * 
	 * @return List of ${link ee.ut.math.tvt.salessystem.domain.data.StockItem}s.
	 */
	public List<StockItem> getAllStockItems();

	public List<Client> getAllClients();

	public List<Sale> getAllSales();

	public Client getClient(long id);

	public void createStockItem(StockItem stockItem);

	/**
	 * Initiate new business transaction - purchase of the goods.
	 * 
	 * @throws VerificationFailedException
	 */
	public void startNewPurchase(Client client);

	/**
	 * Rollback business transaction - purchase of goods.
	 * 
	 * @throws VerificationFailedException
	 */
	public void cancelCurrentPurchase();

	public void setModel(SalesSystemModel model);

	/**
	 * Close all resources
	 */
	public void endSession();

	public void registerSale(Sale sale);

	public SoldItem verifyEnoughInStock(StockItem stockItem, int quantity)
	    throws SalesSystemException;

	public Sale getActiveSale();

	public void addSoldItemToActiveSale(SoldItem soldItem);
}
