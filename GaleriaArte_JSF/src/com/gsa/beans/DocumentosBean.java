package com.gsa.beans;

import java.io.File;
import java.io.IOException;


import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;


import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;

@ManagedBean
public class DocumentosBean 
{
	private ExcelOptions excelDoc;
    
    private PDFOptions pdfDoc;
	
    
    public DocumentosBean()
    {
    	
    }
    
    
    
    
    
    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
         
        HSSFCellStyle cellStyle = wb.createCellStyle();  
        
         
    
    }
    
   
    
    public void preProcessPDFUsuarios(Object document) throws IOException, BadElementException, DocumentException{
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "LogoUsuario.png";
        
         
        pdf.add( Image.getInstance(logo) );
        
    }
    
    public void preProcessPDFAuditoria(Object document) throws IOException, BadElementException, DocumentException{
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "LogoAuditoria.png";
        
         
        pdf.add( Image.getInstance(logo) );
        
    }
    
    public void preProcessPDFExposiciones(Object document) throws IOException, BadElementException, DocumentException{
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "LogoExposiciones.png";
        
         
        pdf.add( Image.getInstance(logo) );
        
    }
    
    public void preProcessPDFObras(Object document) throws IOException, BadElementException, DocumentException{
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "LogoObras.png";
        
         
        pdf.add( Image.getInstance(logo) );
        
    }
    
    public void preProcessPDFTransacciones(Object document) throws IOException, BadElementException, DocumentException{
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "LogoTransacciones.png";
        
         
        pdf.add( Image.getInstance(logo) );
        
    }
	



	public ExcelOptions getExcelDoc() {
		return excelDoc;
	}



	public void setExcelDoc(ExcelOptions excelDoc) {
		this.excelDoc = excelDoc;
	}



	public PDFOptions getPdfDoc() {
		return pdfDoc;
	}



	public void setPdfDoc(PDFOptions pdfDoc) {
		this.pdfDoc = pdfDoc;
	}
    
    
}
