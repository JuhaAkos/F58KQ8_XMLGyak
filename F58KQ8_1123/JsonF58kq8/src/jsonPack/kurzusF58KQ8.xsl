<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version = "1.0" xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<body>
				<h2>Vizsgak adatai - for-each,value-of</h2>
				
				<table border = "4">
					<tr bgcolor = "9acd32">
						<th>kurzus</th>
						<th>helyszin</th>
						<th>nap</th>
						<th>tol</th>
						<th>ig</th>
						<th>oktato</th>
						<th>jegy</th>
					</tr>
					
					<xsl:for-each select="root/vizsga/vizsga">
						<tr>							
							<td><xsl:value-of select = "kurzus"/></td>
							<td><xsl:value-of select = "helyszin"/></td>
							<td><xsl:value-of select = "idopont/nap"/></td>
							<td><xsl:value-of select = "idopont/tol"/></td>
							<td><xsl:value-of select = "idopont/ig"/></td>
							<td><xsl:value-of select = "oktato"/></td>
							<td><xsl:value-of select = "jegy"/></td>
						</tr>
					</xsl:for-each>
					
				</table>
				<table border = "4">
					<tr bgcolor = "9acd32">
						<th>Atlag</th>
					</tr>
					
					<xsl:for-each select="root/vizsga/vizsga">
						<tr>
							<td><xsl:value-of select = "sum(/vizsga/jegy)"/></td>
						</tr>
					</xsl:for-each>	
					
				</table>
				
			</body>
		</html>
		
	</xsl:template>	

</xsl:stylesheet>