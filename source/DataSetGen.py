from random import randrange
from datetime import timedelta
from random import randint
import pandas as pd
from datetime import datetime

def random_date(start, end):
    delta = end - start
    int_delta = (delta.days * 24 * 60 * 60) + delta.seconds
    random_second = randrange(int_delta)
    return start + timedelta(seconds=random_second)

# d1 = datetime.strptime('1/1/2008 1:30 PM', '%m/%d/%Y %I:%M %p')
# d2 = datetime.strptime('1/1/2009 4:50 AM', '%m/%d/%Y %I:%M %p')
# print(random_date(d1, d2))

def generator(datapoints,start_d,end_d,min_w,max_w):
    DATE = []
    weights = []
    barcode = []
    # d1 = datetime.strptime('1/1/2008 1:30 PM', '%m/%d/%Y %I:%M %p')
    # d2 = datetime.strptime('1/1/2009 4:50 AM', '%m/%d/%Y %I:%M %p')
    d1 = datetime.strptime(start_d, '%m/%d/%Y %I:%M %p')
    d2 = datetime.strptime(end_d, '%m/%d/%Y %I:%M %p')
    for i in range(datapoints):
        temp = random_date(d1,d2)
        day = str(temp.day)
        month = str(temp.month)
        year = str(temp.year % 100)
        if temp.day < 10:
            day = '0'+str(day)
        if temp.month < 10:
            month = '0'+str(month)
        if temp.year % 100 < 10:
            year = '0'+str(year)
        
        n = randint(min_w,max_w)
        wt = str(n)
        if(n < 10):
            wt = '00'+str(n)
        elif(n < 100):
            wt = '0'+str(n)

        s = str(day)+str(month)+str(year)+wt
        barcode.append(s)
    
    df = pd.DataFrame(barcode)
    df.to_csv('pro/Data.csv',index=False)

# data_points = int(input("Enter the number of data points : "))
data_points = 50

# start_d = input("Enter the start date : ")
start_d = '10/1/2022 12:00 AM'

# end_d = input("Enter the end date : ")
end_d = '10/4/2022 12:00 AM'

# min_w = int(input("Enter the minimum weight : "))
min_w = 100

# max_w = int(input("Enter the max weight : "))
max_w = 300

generator(data_points,start_d,end_d,min_w,max_w)









# def generator(datapoints,start_d,end_d,min_w,max_w):
#     DATE = []
#     weights = []
#     # d1 = datetime.strptime('1/1/2008 1:30 PM', '%m/%d/%Y %I:%M %p')
#     # d2 = datetime.strptime('1/1/2009 4:50 AM', '%m/%d/%Y %I:%M %p')
#     d1 = datetime.strptime(start_d, '%m/%d/%Y %I:%M %p')
#     d2 = datetime.strptime(end_d, '%m/%d/%Y %I:%M %p')
#     for i in range(datapoints):
#         temp = random_date(d1,d2)
#         day = str(temp.day)
#         month = str(temp.month)
#         year = str(temp.year % 100)
#         if temp.day < 10:
#             day = '0'+str(day)
#         if temp.month < 10:
#             month = '0'+str(month)
#         if temp.year % 100 < 10:
#             year = '0'+str(year)

#         s = str(day)+"/"+str(month)+"/"+str(year)
#         DATE.append(s)
#         n = randint(min_w,max_w)
#         wt = n
#         if(n < 10):
#             wt = '00'+str(n)
#         elif(n < 100):
#             wt = '0'+str(n)
#         weights.append(wt)
#     d= {'Date':DATE,
#         'Weight':weights}
#     df = pd.DataFrame(d)
#     df.to_csv('pro/Data.csv',index=False)