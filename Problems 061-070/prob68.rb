def prob68
  list = [1,2,3,4,5,6,7,8,9,10]
  max = "0"
  list.permutation.to_a.each{|x|
    sum1 = x[0]+x[1]+x[9]
    sum2 = x[0]+x[2]+x[5]
    if sum1 == sum2
      sum3 = x[2]+x[4]+x[6]
      if sum1 == sum3
        sum4 = x[3]+x[4]+x[7]
        if sum1 == sum4
          sum5 = x[1]+x[3]+x[8]
          if sum1 == sum5 # possible solution
            endpoints = [x[5],x[6],x[7],x[8],x[9]]
            case endpoints.index(endpoints.min)
            when 0
              str = [x[5],x[0],x[2],x[6],x[2],x[4],x[7],x[4],x[3],x[8],x[3],x[1],x[9],x[1],x[0]].join
            when 1
              str = [x[6],x[2],x[4],x[7],x[4],x[3],x[8],x[3],x[1],x[9],x[1],x[0],x[5],x[0],x[2]].join
            when 2
              str = [x[7],x[4],x[3],x[8],x[3],x[1],x[9],x[1],x[0],x[5],x[0],x[2],x[6],x[2],x[4]].join
            when 3
              str = [x[8],x[3],x[1],x[9],x[1],x[0],x[5],x[0],x[2],x[6],x[2],x[4],x[7],x[4],x[3]].join
            when 4
              str = [x[9],x[1],x[0],x[5],x[0],x[2],x[6],x[2],x[4],x[7],x[4],x[3],x[8],x[3],x[1]].join
            else
              return nil
            end
            if max < str
              max = str
            end
          end
        end
      end
    end
  }
  max
end

puts prob68