import csv
import numpy as np
from sklearn import linear_model

import matplotlib.pyplot as plt
from sklearn.cross_validation import train_test_split
li=list()
li2=list()
i=0
f_google=''
pred=0.00
filename='google.csv'
dates = []
prices = []
check=[]
curr=""
mydictbuy={}
mydictsell={}


def get_data(filename):
    
    del dates[:]
    del prices[:]
    csvFileReader=""
    with open(filename,'r') as csvfile:
        csvFileReader = csv.reader(csvfile)
        #next(csvFileReader) 
        #skipping column names
        for row in csvFileReader:
            dates.append(int(row[0]))
            prices.append(float(row[1]))


    return
 

def show_plot(dates,prices):
    linear_mod = linear_model.LinearRegression()
    dates = np.reshape(dates,(len(dates),1)) # converting to matrix of n X 1
    prices = np.reshape(prices,(len(prices),1))
    linear_mod.fit(dates,prices) #fitting the data points in the model
    plt.scatter(dates,prices,color='yellow') #plotting the initial datapoints 
    plt.plot(dates,linear_mod.predict(dates),color='blue',linewidth=3) #plotting the line made by linear regression
    plt.show()
    return




def predict_price(dates,prices,x):
    linear_mod = linear_model.LinearRegression() #defining the linear regression model
    dates = np.reshape(dates,(len(dates),1)) # converting to matrix of n X 1
    prices = np.reshape(prices,(len(prices),1))
    linear_mod.fit(dates,prices) #fitting the data points in the model
    predicted_price =linear_mod.predict(x)
    return predicted_price[0][0],linear_mod.coef_[0][0] ,linear_mod.intercept_[0]




def prediction():
    get_data(filename) # calling get_data method by passing the csv file to it
    print dates
    print prices
    print "\n"
    X=dates
    y=prices    
    
    
    X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.4,random_state=0)
    
    if dates[-1]>25 :
        x=1
    else: 
        x = dates[-1]+4
    
    predicted_price, coefficient, constant = predict_price(dates,prices,x)
    
    print "The stock open price for selected date is: $",str(predicted_price)
    print "The regression coefficient is ",str(coefficient),", and the constant is ", str(constant)
    print "the relationship equation between dates and prices is: price = ",str(coefficient),"* ",x ," + ",str(constant) 
    
    
    #writing predicted data back to the csv file as feedback
    fo=open(filename,'a+')
    print>>fo,x,",",predicted_price
    fo.close()
    
    #refetching the data from new generatd csv file to plot the predicted value
    get_data(filename)
    show_plot(dates,prices)
    #image of the plot will be generated. Save it if you 
    #want and then Close it to continue the execution of the below code.
    
    
    #finding accuracy of prediction
    s=len(X_test)
 #   print "length:",s
# to test the trained model
    for i in range(s):
        linear_mod = linear_model.LinearRegression() #defining the linear regression model
        X_train = np.reshape(X_train,(len(X_train),1)) # converting to matrix of n X 1
        y_train = np.reshape(y_train,(len(y_train),1))
        linear_mod.fit(X_train,y_train) #fitting the data points in the model
        temp =linear_mod.predict(X_test[i])
        temp=float(temp)
        check.append(temp)
    #print"check array :"
    
    #print check    
    
    addition=0
    for i in range(s):
        check[i]=y_test[i]-check[i]
    #    print check[i]
        addition+=check[i]
        
    #print "Addition :",addition
    
    per_err=(addition/s)
    #print "Percent error :",per_err,"%"
    
    print "accuracy of the prediction is : + or - ",per_err,"%"
    li2.append(per_err)
    
    if (prices[-1]-predicted_price)<0 :
        mydictsell[curr]=prices[-1]-predicted_price
    else:
        mydictbuy[curr]=prices[-1]-predicted_price



def rewrite(current):
        # append file2 data to file1 data
    
    fin = open(filename, "r")
    data2 = fin.read()
    fin.close()
    
    fout = open("output_file", "a")
    stream=current+data2
    fout.write(stream)
    fout.close()





inp_path="C:\\Users\\aditi\\git\\BreadNBucks\\src\\main\\java\\com\\cummins\\PredictionPython\\dummyInp.csv"
#inp_path="C:\\Users\\bsnl\\Documents\\eclipse\\Citi\\dummyInp.csv"
inpfile=open(inp_path)


for line in inpfile.readlines():
    i+=1	#keep count of lines
    inp=line.split(',')
    if i==1:
        
        f_google=open(filename,'w')
    if inp[0].isdigit():
        inp[0]=int(inp[0])
        inp[1]=float(inp[1])
        #print inp
        
            
        if i<12:
            vari=str(inp[0])+","+str(inp[1])+"\n"
            print vari
            f_google.write(vari)

        if i==11:
            i=0 
            vari=0
            f_google.close()  
     #       get_data(filename)
  #          print dates
   #         print prices
    #        print "\n"   
            prediction()
            rewrite(curr)
            
    else:
        curr=inp[0]
        
        li.append(inp[0])
        print li
        

store=""
fopen=open("final_output.csv","w")
fopen.write("BUY\n")
print "\n BUY \n"
for key in mydictbuy.iterkeys():
  #  print "%s: %s" % (key, mydictbuy[key])
    print key
    store=str(key)+"\n"
    fopen.write(store)
fopen.write("SELL\n")
print "\n SELL \n"
for key in mydictsell.iterkeys():
   # print "%s: %s" % (key, mydictsell[key])
    print key
    store=str(key)+"\n"
    fopen.write(store)
    
fopen.close()