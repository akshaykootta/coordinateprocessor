package com.mufg.coordinateprocessor.daoImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mufg.coordinateprocessor.dao.CoordinateLengthDao;
import com.mufg.coordinateprocessor.model.Coordinate;
import com.mufg.coordinateprocessor.util.CoordinateConstants;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@Repository
public class CoordinateLengthDaoImpl implements CoordinateLengthDao {

	private static final Logger logger = LoggerFactory.getLogger(CoordinateLengthDaoImpl.class);

	@Override
	public Integer saveToCsv(List<Coordinate> cordinateList) {
		final String CSV_LOCATION = CoordinateConstants.CSV_File_Location;
		FileWriter writer = null;
		try {
			logger.info("Writing Cordinates Entries to CSV file");
			writer = new FileWriter(CSV_LOCATION);

			ColumnPositionMappingStrategy<Coordinate> mappingStrategy = new ColumnPositionMappingStrategy<Coordinate>();
			mappingStrategy.setType(Coordinate.class);

			StatefulBeanToCsvBuilder<Coordinate> builder = new StatefulBeanToCsvBuilder<Coordinate>(writer);
			StatefulBeanToCsv<Coordinate> beanWriter = builder.withMappingStrategy(mappingStrategy).build();

			beanWriter.write(cordinateList);
			logger.info("Write Successful!");

			return 1;
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}

		return 0;
	}

	@Override
	public List<Coordinate> readFromCsv() {

		List<Coordinate> cordinateList = new ArrayList<>();
		ColumnPositionMappingStrategy<Coordinate> strategy = new ColumnPositionMappingStrategy<Coordinate>();
		strategy.setType(Coordinate.class);
		logger.info("Reading Cordinates Entries from CSV file");
		CSVReader csvReader = null;
		try {

			csvReader = new CSVReader(new FileReader(CoordinateConstants.CSV_File_Location));
			CsvToBean<Coordinate> csvToBean = new CsvToBean<Coordinate>();
			cordinateList = csvToBean.parse(strategy, csvReader);
			logger.info("Sucessfully Read Cordinates");
			logger.info(cordinateList.toString());
			
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException" + e.getMessage());
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return cordinateList;

	}

}
