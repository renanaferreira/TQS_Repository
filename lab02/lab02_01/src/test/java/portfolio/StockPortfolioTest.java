package portfolio;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockPortfolioTest {

    private static final String IBM_NAME = "IBM";
    private static final String NOS_NAME = "NOS";

    @InjectMocks
    private StockPortfolio portfolio;

    @Mock
    private IStockMarket mockMarket1;

    @Test
    public void testGetTotalValue() {

        //Mock preparation
        double sm_price_ibm = 15.0;
        double sm_price_nos = 5.5;

        int qt_ibm = 10;
        int qt_nos = 37;

        when(mockMarket1.getPrice(IBM_NAME)).thenReturn(sm_price_ibm);
        when(mockMarket1.getPrice(NOS_NAME)).thenReturn(sm_price_nos);

        //test
        portfolio.addStock(new Stock(IBM_NAME, qt_ibm));
        portfolio.addStock(new Stock(NOS_NAME, qt_nos));
        portfolio.setMarketService(mockMarket1);

        double correctValue = sm_price_ibm*qt_ibm + sm_price_nos*qt_nos;
        assertEquals(correctValue, portfolio.getTotalValue());

        // Verify object interactions with mock object
        verify(mockMarket1, times(2)).getPrice(anyString());
        verify(mockMarket1).getPrice(IBM_NAME);
        verify(mockMarket1).getPrice(NOS_NAME);

    }

    @Test
    public void testGetTotalValue2() {

        //Mock preparation
        double sm_price_ibm = 15.0;
        double sm_price_nos = 5.5;

        int qt_ibm = 10;
        int qt_nos = 37;

        when(mockMarket1.getPrice(IBM_NAME)).thenReturn(sm_price_ibm);
        when(mockMarket1.getPrice(NOS_NAME)).thenReturn(sm_price_nos);

        //test
        portfolio.addStock(new Stock(IBM_NAME, qt_ibm));
        portfolio.addStock(new Stock(NOS_NAME, qt_nos));
        portfolio.setMarketService(mockMarket1);

        double correctValue = sm_price_ibm*qt_ibm + sm_price_nos*qt_nos;

        assertThat(portfolio.getTotalValue(), is(correctValue));

        // Verify object interactions with mock object
        verify(mockMarket1, times(2)).getPrice(anyString());
        verify(mockMarket1).getPrice(IBM_NAME);
        verify(mockMarket1).getPrice(NOS_NAME);

    }








}
